package com.bufoon.action;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.base.model.UseValue;
import com.base.model.WeixinOAuth2Token;
import com.bufoon.entity.AuthorizerInfoMaster;
import com.bufoon.entity.MerchantPayInfoMaster;
import com.bufoon.entity.RedPackInfo;
import com.bufoon.entity.StoresInfo;
import com.bufoon.entity.YRedPackInfoMaster;
import com.bufoon.redbao.HttpUtil;
import com.bufoon.redbao.WechatRedPackRequest;
import com.bufoon.redbao.WechatUtils;
import com.bufoon.service.AuthorizerInfoService;
import com.bufoon.service.MerchantPayInfoService;
import com.bufoon.service.RedPackInfoService;
import com.bufoon.service.StoresService;
import com.bufoon.service.YRedPackInfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.wechat.util.OAuth2Util;

public class RedPackAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
	@Resource
    private StoresService storesService;
    @Resource
    private AuthorizerInfoService authorizerInfoService;
	@Resource
	private RedPackInfoService redPackInfoService;
	@Resource
    private MerchantPayInfoService merchantPayInfoService;
	@Resource
    private YRedPackInfoService yRedPackInfoService;
/*    private StoresInfo storesInfo;
    
    public StoresInfo getStoresInfo() {
		return storesInfo;
	}
	public void setStoresInfo(StoresInfo storesInfo) {
		this.storesInfo = storesInfo;
	}*/

	private static Logger log = Logger.getLogger(RedPackAction.class);
    
  //
    public void redPack() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String success ="{'result': 'sorry'}";
		JSONArray json = new JSONArray();
		String openId=(String)request.getSession().getAttribute("openId");
		
		if(openId!=null){
			Integer result = checkSended(openId);
			if (result!=null) {
				boolean sendresult = sendRedPack(openId,result);
				if(sendresult){
					saveRedPack(openId,request);
					success ="{'result': 'success'}";
				}
			}
		}
		json.add(success);
		response.getWriter().print(json.toString());
		return;
    }
	//查看这个用户有没有领到红包，没有就保存数据库并发送红包
  	private Integer checkSended(String redOpenId) throws Exception {
  		//String sql = "select * from m_redpack_info where record_status=1 and openid='" + redOpenId + "'";
  		Integer result = getRandomMoney();
  			//Integer result =RedPackUtils.getRandomMoney();
		if (result != null && result >= 1) {
			RedPackInfo redInfo = new RedPackInfo();
			redInfo.setAppid(UseValue.CustAppId);
			redInfo.setCashNumber(result.toString());
			redInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
			redInfo.setOpenid(redOpenId);
			redInfo.setRecordStatus(0);
			YRedPackInfoMaster yRedPackInfoMaster = yRedPackInfoService.getYRedPackInfoMaster("select * from y_redpackinfo where appid='" + UseValue.CustAppId + "'");
			Float i=(100*Float.parseFloat(yRedPackInfoMaster.getRedpackBalance())-result)/100;
			yRedPackInfoMaster.setRedpackBalance(i.toString());
			yRedPackInfoService.updateYRedPackInfoMaster(yRedPackInfoMaster);
			redPackInfoService.saveRedPackInfo(redInfo);
			
		}
  			return result;
  	}
  	//将这个用户设置为已经领取了红包的状态
  	private void saveRedPack(String redOpenId,HttpServletRequest request) throws Exception {
  		RedPackInfo redInfo=redPackInfoService.getRedPackInfo("select * from c_redpack_info where record_status=0 and openid='" + redOpenId + "' and appid='"+UseValue.CustAppId+"'");
  		redInfo.setRecordStatus(1);
  		redPackInfoService.updateRedPackInfo(redInfo);	
  		//将得到红包的人的redOpenId放到Session里防止他再次摇到
		/*request.getSession().setAttribute("redOpenId",redOpenId);*/
  	}
  	//从数据库中找对应的商户提交红包的资料
  	private MerchantPayInfoMaster yRedPack() throws Exception{
    	HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String openId=(String)request.getSession().getAttribute("openId");
		
		MerchantPayInfoMaster yRedPackInfo=new MerchantPayInfoMaster();
		if(openId!=null){
			yRedPackInfo=merchantPayInfoService.getMerchantPayInfoMaster("select * from y_merchantpayinfo where appid='"+UseValue.AppId+"'");
			/*String MCH_ID = yRedPackInfo.getStoreNumber();
			String APP_ID = yRedPackInfo.getAppid();
			String KEY = yRedPackInfo.getApiKey();
			String KEY_PATH = yRedPackInfo.getApiCert();
			String API_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";*/
			return yRedPackInfo;
		}
		return null;
    }
	
  	private boolean sendRedPack(String openId,int num) throws Exception {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        /*
	         * 构建请求参数
	         */
		  MerchantPayInfoMaster yRedPackInfo=new MerchantPayInfoMaster();
		  //红包的api等
		  	yRedPackInfo = yRedPack();
		  	//红包的活动资料
		  	YRedPackInfoMaster yRedPackInfoMaster = yRedPackInfoService.getYRedPackInfoMaster("select * from y_redpackinfo where appid='" + UseValue.CustAppId + "'");
		  	AuthorizerInfoMaster authorizerInfo=authorizerInfoService.getAuthorizerInfoMatser("select * from y_authorizer_info where appid='" + UseValue.CustAppId + "'");
		  	
		  	
	        WechatRedPackRequest request = new WechatRedPackRequest();
	        request.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
	        request.setMch_id(yRedPackInfo.getStoreNumber());
	        String ranStr = getRandom();
	        // 商户订单号（每个订单号必须唯一） 组成： mch_id+yyyymmdd+10位一天内不能重复的数字
	        String mchBillno = yRedPackInfo.getStoreNumber() + sdf.format(new Date()) + ranStr;
	        request.setMch_billno(mchBillno);
	       
	       /* String title=new String(yRedPackInfo.getStoreNumber().getBytes());
	        String title1=new String(yRedPackInfoMaster.getRedpackName().getBytes());*/
	        
	        //log.info("yRedPackInfoMaster.getRedpackName().substring(0,32)"+yRedPackInfoMaster.getRedpackName().substring(0,32));
	        
	        
	        
	        request.setWxappid(yRedPackInfo.getAppid());
	        request.setNick_name(authorizerInfo.getNickName());
		    request.setSend_name(authorizerInfo.getNickName());
	        request.setRe_openid(openId); // 接收者的微信openId;

	        // 以分为单位
	        request.setTotal_amount(num);
	        request.setMin_value(num);
	        request.setMax_value(num);
	        request.setTotal_num(1);
	        //request.setLogo_imgurl(UseValue.headImg);
	        request.setWishing(yRedPackInfoMaster.getRedpackTitle());
	        request.setClient_ip("127.0.0.1");
	        request.setAct_name(yRedPackInfoMaster.getRedpackName());
	        request.setRemark(yRedPackInfoMaster.getRedpackTitle());
	        String sign = "";
	        try {
	            sign = WechatUtils.buildRequestSign(request, yRedPackInfo.getApiKey());
	        } catch (Exception e) {
	            throw e;
	        }
	       // log.info("sign签名"+sign);
	        request.setSign(sign);

	        /*
	         * 发送请求并解析返回的xml
	         */
	        FileInputStream instream = new FileInputStream(new File(yRedPackInfo.getApiCert()));

	        String API_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	        String resp = HttpUtil.wechatPost(API_URL,yRedPackInfo.getStoreNumber(),
	                WechatUtils.convertObjectToXml(request, WechatRedPackRequest.class), instream);
	        //log.info("微信返回的信息:"+resp);
	        if(resp.contains("SUCCESS")){
	        	return true;
	        }
	        return false;
	}
	/**
	 * 生成金额1-1.5
	 * @return
	 */
	public  Integer getRandomMoney(){
		YRedPackInfoMaster yRedPackInfoMaster = yRedPackInfoService.getYRedPackInfoMaster("select * from y_redpackinfo where appid='" + UseValue.CustAppId + "'");
		Integer min=(int) ((Integer)100*Float.parseFloat(yRedPackInfoMaster.getRedpackMinMoney()));
		Integer max=(int) ((Integer)100*Float.parseFloat(yRedPackInfoMaster.getRedpackMaxMoney()));
		//int num =1 * (100+new Random().nextInt(14));//rand.nextInt(14)，调用random的方法，生成0-13之间的一个随机数。
		int num=new Random().nextInt(max)%(max-min+1) + min;
		return num;
		
	}
	/**
	 * 升级随机订单的后十位
	 * @return
	 */
	private static String getRandom() {
		Random r = new Random();
		long num = Math.abs(r.nextLong() % 10000000000L);
		String s = String.valueOf(num);
		for (int i = 0; i < 10 - s.length(); i++) {
			s = "0" + s;
		}

		return s;
	}
}

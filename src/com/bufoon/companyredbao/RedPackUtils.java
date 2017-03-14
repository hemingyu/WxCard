package com.bufoon.companyredbao;
/*package com.bufoon.redbao;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.base.model.UseValue;

*//**
 * 红包发送工具
 * 
 * @author liulihai oCyyKt5ZW3wzEMn71-_a-t3zTS8M
 *//*
public class RedPackUtils {
	private static Logger log = Logger.getLogger(RedPackUtils.class);
	
	public static boolean sendRedPack(String openId,int num) throws Exception {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        
	         * 构建请求参数
	         
	        WechatRedPackRequest request = new WechatRedPackRequest();
	        request.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
	        request.setMch_id(RedBaoConfig.MCH_ID);
	        String ranStr = getRandom();
	        // 商户订单号（每个订单号必须唯一） 组成： mch_id+yyyymmdd+10位一天内不能重复的数字
	        String mchBillno = RedBaoConfig.MCH_ID + sdf.format(new Date()) + ranStr;
	        request.setMch_billno(mchBillno);
	        
	        request.setWxappid(RedBaoConfig.APP_ID);
	        request.setNick_name("比文科技送红包");
	        request.setSend_name("比文科技送红包");
	        request.setRe_openid(openId); // 接收者的微信openId;

	        // 以分为单位
	        request.setTotal_amount(num);
	        request.setMin_value(num);
	        request.setMax_value(num);
	        request.setTotal_num(1);
	        //request.setLogo_imgurl(UseValue.headImg);
	        request.setWishing("感谢您参加活动,摇摇更快乐");
	        request.setClient_ip("127.0.0.1");
	        request.setAct_name("红包抢先摇!");
	        request.setRemark("摇红包,带朋友一起摇!");
	        String sign = "";
	        try {
	            sign = WechatUtils.buildRequestSign(request, RedBaoConfig.KEY);
	        } catch (Exception e) {
	            throw e;
	        }
	       // log.info("sign签名"+sign);
	        request.setSign(sign);

	        
	         * 发送请求并解析返回的xml
	         
	        FileInputStream instream = new FileInputStream(new File(RedBaoConfig.KEY_PATH));

	        String resp = HttpUtil.wechatPost(RedBaoConfig.API_URL,
	                WechatUtils.convertObjectToXml(request, WechatRedPackRequest.class), instream);
	        //log.info("微信返回的信息:"+resp);
	        if(resp.contains("SUCCESS")){
	        	return true;
	        }
	        return false;
	}
	*//**
	 * 生成金额1-1.5
	 * @return
	 *//*
	public  static Integer getRandomMoney(){
		int num =1 * (100+new Random().nextInt(14));//rand.nextInt(14)，调用random的方法，生成0-13之间的一个随机数。
		return num;
		
	}
	*//**
	 * 升级随机订单的后十位
	 * @return
	 *//*
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
*/
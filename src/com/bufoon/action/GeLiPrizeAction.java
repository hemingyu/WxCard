package com.bufoon.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.base.model.UseValue;
import com.bufoon.entity.ActiveCardsMaster;
import com.bufoon.entity.ActiveMaster;
import com.bufoon.entity.RedPackInfo;
import com.bufoon.entity.UserInfoMaster;
import com.bufoon.entity.WxFromCardInfoMaster;
import com.bufoon.entity.YRedPackInfoMaster;
import com.bufoon.service.ActiveCardsService;
import com.bufoon.service.ActiveService;
import com.bufoon.service.RedPackInfoService;
import com.bufoon.service.UserInfoService;
import com.bufoon.service.WxFromCardInfoService;
import com.bufoon.service.YRedPackInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class GeLiPrizeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource
	private ActiveCardsService activeCardsService;
	@Resource
	private UserInfoService userInfoService;
	@Resource
    private YRedPackInfoService yRedPackInfoService;
	@Resource
	private ActiveService activeService;
	@Resource
	private WxFromCardInfoService wxFromCardInfoService;
	
	private static Logger log = Logger.getLogger(GeLiPrizeAction.class);

	// 当用户不是第一次进入
	public void geLiPrize() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");

		String openId = request.getParameter("openId");
		log.info("openId = "+openId);
		
		UserInfoMaster info = userInfoService.getUserInfoMaster("select * from c_userinfo where openid = '"+openId+"' and appid='"+UseValue.CustAppId+"'");
		if (info != null){
    			Integer num = Integer.valueOf(info.getSharkNo());
    			Map<String, String> cardIdAndAppId = new HashMap<String, String>();
    			if (num != 0){
    			    num-=1;
    			    info.setSharkNo(num+"");
    			    userInfoService.updateUserInfoMaster(info);
    			    //随机选出一张卡券
    			    Map<Integer, Object> cardIdAndRedPack = getRandomCard(openId,num);//因为使用了 num-=1;所以num为0时是可以摇的
    			    if(!cardIdAndRedPack.isEmpty()&&cardIdAndRedPack.containsKey(1)){
    			    	ActiveCardsMaster cardInfo = (ActiveCardsMaster)cardIdAndRedPack.get(1);
    			    	String cardId = cardInfo.getCardId();
    	        	    String cardTitle = cardInfo.getCardTitle();
    	        	    cardIdAndAppId.put("CardTitle", cardTitle);
    	        	    cardIdAndAppId.put("CardId", cardId);
    	        	    
    	        	    String AppId = cardInfo.getAppid();
    	        	    cardIdAndAppId.put("AppId", AppId);
    	        	    log.info("CardId="+cardId);
    			    }else if(!cardIdAndRedPack.isEmpty()&&cardIdAndRedPack.containsKey(2)){
    			    	YRedPackInfoMaster yRedPackInfoMaster = (YRedPackInfoMaster)cardIdAndRedPack.get(2);
    					Integer j=Integer.parseInt(yRedPackInfoMaster.getSingleGetReapackNumber());
    					Integer k=Integer.parseInt(info.getLog1());
    					log.info("yRedPackInfoMaster.getRedpackStatus()="+yRedPackInfoMaster.getRedpackStatus()+"j="+j+"k="+k);
    					if(k<j){
            		    		cardIdAndAppId.put("Redpack", "success");
            		    		cardIdAndAppId.put("RedpackState", "redpack");
            		    		//将log1字段作为红包领取状态,1为领取
            		    		updateUserInfo(info);
    					}
    					/*cardIdAndAppId.put("Redpack", "success");
    		    		cardIdAndAppId.put("RedpackState", "company");*/
    			    }
			    	 cardIdAndAppId.put("Count", info.getSharkNo());
		        	 JSONArray json =JSONArray.fromObject(cardIdAndAppId);
		        	 response.getWriter().print(json.toString());  
    		} else{
    		    log.info("num="+num);
    		    response.getWriter().print(JSONArray.fromObject(cardIdAndAppId));
    		}
		}
	}


	/**
	 * @return
	 * @throws Exception 
	 */
	//要做活动的商家选择的一些卡券随机选出一张卡券
	private Map<Integer, Object> getRandomCard(String openId,int numPrize) throws Exception{
		//ActiveCardsMaster cardinfo = null;
		Map<Integer, Object> cardIdAndRedPack = new HashMap<Integer, Object>();
		int num =new Random().nextInt(10000)+1;//生成1到10000随机数
		int j=0,i=0;
		int keyPrize=0;
		//List<ActiveCardsMaster> cardList = ActiveCardsService.findAllList("from CardInfoMaster where cardStatusName='已投放' and appid='"+UseValue.AppId+"'");
		
		//要做活动的商家选择的一些卡券随机选出一张卡券
		List<ActiveCardsMaster> cardList = activeCardsService.findAllList("from ActiveCardsMaster where card_status=1 and chose_appid='"+UseValue.CustAppId+"'");
		YRedPackInfoMaster yRedPackInfoMaster = yRedPackInfoService.getYRedPackInfoMaster("select * from y_redpackinfo where redpack_status='1' and appid='"+UseValue.CustAppId+"'");
		
		if(yRedPackInfoMaster!=null){
			Float k=Float.parseFloat(yRedPackInfoMaster.getRedpackBalance());
			Float maxMoney=Float.parseFloat(yRedPackInfoMaster.getRedpackMaxMoney());
			if(k>maxMoney){
				j=i+Integer.parseInt(yRedPackInfoMaster.getPrizeRate())*100;
				if(i<num&&num<j){
					keyPrize=2;
					cardIdAndRedPack.put(keyPrize, yRedPackInfoMaster);
				}
				i=j;
			}
			log.info("红包:"+yRedPackInfoMaster.getPrizeRate()+"num"+num+"i="+i+"j="+j+"cardIdAndRedPack"+cardIdAndRedPack);
		}
		if(cardIdAndRedPack.isEmpty()&&(!cardList.isEmpty())){
			for(ActiveCardsMaster cardinfo:cardList){
				j=(int)(cardinfo.getCardProbability()*100)+i;//记录当前与前面卡券的概率和
				if(i<num&&num<j){
					keyPrize=1;
					cardIdAndRedPack.put(keyPrize, cardinfo);
				}
				i=i+(int)(cardinfo.getCardProbability()*100);//记录当前与前面卡券的概率和
			}
			log.info("卡券num:"+num+"i="+i+"j="+j+"cardIdAndRedPack"+cardIdAndRedPack);
		}	
		if((numPrize==0&&cardIdAndRedPack.isEmpty())||(numPrize==0&&!cardIdAndRedPack.isEmpty()&&!cardIdAndRedPack.containsKey(1))){
			//判断用户是否领取了卡券
			WxFromCardInfoMaster wxFromCardInfoMaster=wxFromCardInfoService.getWxFromCardInfoMaster("select * from y_wxfromcardinfo where appid='"+UseValue.CustAppId+"' and openid='"+openId+"' and get_card='1'");
			ActiveMaster active = activeService.getActiveMaster("select * from y_active where appid='"+UseValue.CustAppId+"'");
			if(wxFromCardInfoMaster==null&&active!=null&&active.getMustOneWinStatus()==1&&!cardList.isEmpty()){
				cardIdAndRedPack.clear();
				Random random = new Random();
				num = random.nextInt(cardList.size());
		    	ActiveCardsMaster cardinfo = cardList.get(num);
		    	keyPrize=1;
				cardIdAndRedPack.put(keyPrize, cardinfo);
			}
			log.info("最后一次:"+num+"i="+i+"j="+j+"cardIdAndRedPack"+cardIdAndRedPack);
		}
		log.info("numPrizeaaa:"+numPrize);
		return cardIdAndRedPack;
	}
	//将c_userinfo表的log1字段作为红包领取状态,领取次数叠加
	private void updateUserInfo(UserInfoMaster info) {
		Integer i=Integer.parseInt(info.getLog1())+1;
		info.setLog1(i.toString());
		userInfoService.updateUserInfoMaster(info);
	}
}

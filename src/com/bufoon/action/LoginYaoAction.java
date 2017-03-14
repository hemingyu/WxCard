package com.bufoon.action;

import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.base.model.UseValue;
import com.bufoon.entity.ActiveMaster;
import com.bufoon.entity.AuthorizerInfoMaster;
import com.bufoon.entity.QueryAuthMaster;
import com.bufoon.entity.StoresInfo;
import com.bufoon.entity.SubscribeInfoMaster;
import com.bufoon.entity.UserInfoMaster;
import com.bufoon.service.ActiveService;
import com.bufoon.service.QueryAuthMasterService;
import com.bufoon.service.StoresService;
import com.bufoon.service.SubscribeInfoService;
import com.bufoon.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.wechat.util.OAuth2Util;

public class LoginYaoAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private StoresService storesService;
    @Resource
    private QueryAuthMasterService queryAuthMasterService;
    @Resource
    private SubscribeInfoService subscribeInfoService;
    @Resource
    private ActiveService activeService;
    private UserInfoMaster userinfo;
    private String globalOpenId;
    private StoresInfo storesInfo;
    
    public StoresInfo getStoresInfo() {
		return storesInfo;
	}
	public void setStoresInfo(StoresInfo storesInfo) {
		this.storesInfo = storesInfo;
	}

    private static Logger log = Logger.getLogger(WelcomeAction.class);
    
    
    public String loginYao() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		log.info("欢迎进入loginYao");
		String openId=(String)request.getSession().getAttribute("openId");
		if(openId==null||"".equals(openId)){
			storesInfo = storesService.getStoresInfo("select * from y_stores where appid = '" + UseValue.CustAppId+ "' limit 1");
			if (storesInfo != null){
			    request.setAttribute("storesInfo", storesInfo);
			    return "sorry";
			}
		}
		userinfo=userInfoService.getUserInfoMaster("select * from c_userinfo where openid = '"+openId+"' and appid='"+UseValue.CustAppId+"'");
		//判断当前的时间与活动的时间比较
		ActiveMaster active = activeService.getActiveMaster("select * from y_active where appid='"+UseValue.CustAppId+"'");
		if (active != null){
		    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		    if (currentTime.before(active.getActiveStartTime())){
			request.setAttribute("info", "活动还没开始哦");
			request.setAttribute("timeString", "活动开始时间");
			request.setAttribute("time", active.getActiveStartTime());
			return "notstart";
		    } else if(currentTime.after(active.getActiveEndTime())){
			request.setAttribute("info", "活动已经结束啦");
			request.setAttribute("timeString", "活动结束时间");
			request.setAttribute("time", active.getActiveEndTime());
			return "notstart";
		    }
		}
		Integer num = Integer.valueOf(userinfo.getSharkNo());
		if (num == 0){
			globalOpenId = userinfo.getOpenid();
		   return ERROR;
		}
		else {
		    request.setAttribute("userinfo", userinfo);
		    return SUCCESS;
		}
    }
    //得到是否关注
    public void getAttion() throws Exception{
 		HttpServletRequest request = ServletActionContext.getRequest();
 		request.setCharacterEncoding("utf-8");
 		HttpServletResponse response = ServletActionContext.getResponse();
 		response.setCharacterEncoding("utf-8");
 		String success=null;
 		JSONArray json = new JSONArray();
 		
 		String openId=(String)request.getSession().getAttribute("openId");
 		if(openId!=null){
 			//订阅号不能得到用户的基本信息（无法得到openid）
 			if("1".equals(UseValue.Status)){
		 		QueryAuthMaster queryAuthMaster=queryAuthMasterService.getQueryAuthMaster("select * from y_query_auth where record_status=0 and authorizer_appid = '" + UseValue.CustAppId+ "'");
		 		//得到微信的关注提示需要的是接口凭证
		 		JSONObject jsonObject=OAuth2Util.getAttention(openId,queryAuthMaster.getAuthorizerAccessToken());
		 		//得到关注提示，为0则没有关注1则关注
		 		try {
		 			Integer subscribe = 1;
		 			//saveSubscribeEvent(openId,subscribe);
		 			ActiveMaster active = activeService.getActiveMaster("select * from y_active where appid='"+UseValue.CustAppId+"'");
		 			if(active!=null&&active.getLog1()!=null&&"1".equals(active.getLog1())){
		 				subscribe = jsonObject.getInt("subscribe");
		 			}
		 			//Integer subscribe=1;
		 			if(1==subscribe){
		 				success ="{'result': 'success'}";
		 			}else{
		 				success ="{'result': 'fail'}";
		 			}
		 		} catch (Exception e) {
		 			log.info("message"+jsonObject);
		 			success ="{'result': 'sorry'}";
		 		}
 			}else{
 				success ="{'result': 'success'}";
 			}
 		}else{
 			success ="{'result': 'sorry'}";
 		}
 		json.add(success);
		response.getWriter().print(json.toString());
    }
    //用户进入分享页面
    public String share() throws Exception{
    	HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String openId=(String)request.getSession().getAttribute("openId");
		if (openId == null||"".equals(openId)){
			storesInfo = storesService.getStoresInfo("select * from y_stores where appid = '" + UseValue.CustAppId+ "' limit 1");
			if (storesInfo != null){
			    request.setAttribute("storesInfo", storesInfo);
			    return "sorry";
			}
			return "sorry";
		}
		return SUCCESS;
    }
	/*
	 * 保存关注，取消关注的信息
	 * 
	 */
   /* public void saveSubscribeEvent(String openid,int subscribe) {
		// TODO Auto-generated method stub
		SubscribeInfoMaster subscribeInfoMaster = subscribeInfoService.getSubscribeInfoMaster("select * from y_subscribeinfo where openid='"+openid+"' and subscribe='"+subscribe+"'");
		if(subscribeInfoMaster!=null){
			subscribeInfoMaster.setCreateTime(new Timestamp(System.currentTimeMillis()));
			subscribeInfoService.updateSubscribeInfoMaster(subscribeInfoMaster);
		}else{
			SubscribeInfoMaster subscribeInfo = new SubscribeInfoMaster();
			subscribeInfo.setAppid(UseValue.CustAppId);
			subscribeInfo.setOpenid(openid);
			subscribeInfo.setSubscribe(subscribe+"");
			subscribeInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
			subscribeInfoService.saveSubscribeInfoMaster(subscribeInfo);
		}
	}*/
    
	public UserInfoMaster getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfoMaster userinfo) {
		this.userinfo = userinfo;
	}
	
    public String getGlobalOpenId() {
        return globalOpenId;
    }

    public void setGlobalOpenId(String globalOpenId) {
        this.globalOpenId = globalOpenId;
    }
}

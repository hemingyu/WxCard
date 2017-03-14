package com.bufoon.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.base.model.UseValue;
import com.bufoon.service.ShareUserInfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.wechat.util.Sign;

@Controller
public class WechatConfigAction extends ActionSupport{
	private static Logger log = Logger.getLogger(WechatConfigAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ShareUserInfoService shareUserInfoService;
	
	public void wechatConfig() throws Exception{
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpServletResponse response =  ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String currentUrl =request.getParameter("currentUrl");
		String appid=request.getParameter("appid");
		String cardId=request.getParameter("cardId");
		Map<String,String> configMap=Sign.sign(currentUrl,appid);
		if(configMap!=null &&configMap.size()>0){
			String cardTicket =Sign.getCardTicket(appid);
			String cardSignature=Sign.getSignature(cardTicket, configMap.get("timestamp"), cardId);
			configMap.put("cardSignature", cardSignature);
			JSONArray json =JSONArray.fromObject(configMap);
//			log.info("currentUrl："+currentUrl+"appid："+appid+"cardId："+cardId+"cardSignature："+cardSignature+"timestamp："+timestamp);
			response.getWriter().print(json.toString());
		}
	}
	
	//获取微信config函数的参数
	public void wechatSignConfig() throws Exception{
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpServletResponse response =  ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		String currentUrl =request.getParameter("currentUrl");
		Map<String,String> configMap=Sign.sign(currentUrl,UseValue.CustAppId);
		if(configMap!=null &&configMap.size()>0){
		    
		    JSONArray json = JSONArray.fromObject(configMap);
		    log.info(configMap.toString());
		    response.getWriter().print(json.toString());
		}
	}
}

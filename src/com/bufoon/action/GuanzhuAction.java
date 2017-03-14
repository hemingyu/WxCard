package com.bufoon.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.base.model.UseValue;
import com.bufoon.entity.AuthorizerInfoMaster;
import com.bufoon.entity.Login;
import com.bufoon.entity.StoresInfo;
import com.bufoon.service.AuthorizerInfoService;
import com.bufoon.service.LoginService;
import com.bufoon.service.StoresService;
import com.opensymphony.xwork2.ActionSupport;

public class GuanzhuAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    @Resource
    private LoginService loginService;
    @Resource
    private StoresService storesService;
    
    private Login loginMaster;
    private StoresInfo storesInfo;
    
    public StoresInfo getStoresInfo() {
		return storesInfo;
	}
	public void setStoresInfo(StoresInfo storesInfo) {
		this.storesInfo = storesInfo;
	}

	private static Logger log = Logger.getLogger(WelcomeAction.class);
    
    //用户进入关注页面
    public String guanzhu() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		loginMaster=loginService.getLogin("select * from y_login where appid='"+UseValue.CustAppId+"' and record_status=0");
		if(loginMaster==null||"".equals(loginMaster)){
			storesInfo = storesService.getStoresInfo("select * from y_stores where appid = '" + UseValue.CustAppId+ "' limit 1");
			if (storesInfo != null){
			    request.setAttribute("storesInfo", storesInfo);
			    return "sorry";
			}
		}
		request.setAttribute("loginMaster", loginMaster);
		return SUCCESS;
	 }
    //用户已经摇完了
    public String gameOver() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String openId=(String)request.getSession().getAttribute("openId");
		if(openId==null||"".equals(openId)){
			storesInfo = storesService.getStoresInfo("select * from y_stores where appid = '" + UseValue.CustAppId+ "' limit 1");
			if (storesInfo != null){
			    request.setAttribute("storesInfo", storesInfo);
			    return "sorry";
			}
		}
		return SUCCESS;
	 }
    
	public Login getLoginMaster() {
		return loginMaster;
	}

	public void setLoginMaster(Login loginMaster) {
		this.loginMaster = loginMaster;
	}

}

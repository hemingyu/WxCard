package com.base.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



import com.base.model.UseValue;
import com.base.model.WeixinOAuth2Token;
import com.wechat.util.OAuth2Util;

/**
 * Servlet implementation class CardOAuth
 * 
 */

public class yaoyiyao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(yaoyiyao.class.getName());
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Prama", "no-cache");
		String appid = request.getParameter("appid");
		String custAppid = request.getParameter("custAppid");
		String status = request.getParameter("status");
		UseValue.Status=status;
		if("1".equals(status)){
			UseValue.AppId=custAppid;
			UseValue.CustAppId=custAppid;
			log.info("可以看到UseValue.AppId："+UseValue.AppId+"和UseValue.CustAppId:"+UseValue.CustAppId);
		}else{
			UseValue.AppId=appid;
			UseValue.CustAppId=custAppid;
			log.info("可以看到UseValue.AppId："+UseValue.AppId+"和和UseValue.CustAppId:"+UseValue.CustAppId);
		}
		/*String url ="https://open.weixin.qq.com/connect/oauth2/authorize?"
		 		+"appid="+appid+"&redirect_uri=http%3A%2F%2F"+UseValue.Url+"%2FCard%2FCardOAuth"
		 		+"&response_type=code&scope=snsapi_base&state="+appid+"&component_appid="+UseValue.ComponentAppid+"#wechat_redirect"; 
		response.sendRedirect(url);*/	
		request.getRequestDispatcher("/yaoyiyao.jsp?appid="+UseValue.AppId+"&code=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

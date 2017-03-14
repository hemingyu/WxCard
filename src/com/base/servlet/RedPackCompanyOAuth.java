/*package com.base.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import com.base.model.UseValue;
import com.base.model.WeixinOAuth2Token;
import com.wechat.util.OAuth2Util;

*//**
 * Servlet implementation class RedPackOAuth
 * 
 *//*

public class RedPackCompanyOAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(RedPackCompanyOAuth.class.getName());
	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String code = request.getParameter("code");
		String appId = request.getParameter("state");
		UseValue.AppId=appId;
		//request.getSession().setAttribute("openId", openId);
		if (code!=null &&!"authdeny".equals(code)) {
			try{
				// 获取网页授权Access_token
				request.getRequestDispatcher("/getRed.jsp?state=2&code="+code).forward(request, response);	    
			}catch(Exception e){
				e.printStackTrace();
				log.info("请求异常");
			}
		}
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
*/
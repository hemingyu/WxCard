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
 * Servlet implementation class SendRedPackOAuth
 * 
 */

public class SendRedPackOAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(SendRedPackOAuth.class.getName());
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String redpackOrCompany = request.getParameter("redpackOrCompany");
		if("redpack".equals(redpackOrCompany)){
			/*String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+UseValue.AppId
					+"&redirect_uri=http%3A%2F%2F"+UseValue.Url+"%2FCard%2FRedPackOAuth&response_type=code"
					+"&scope=snsapi_base&state="+UseValue.AppId+"&component_appid="+UseValue.ComponentAppid+"#wechat_redirect";
			response.sendRedirect(url);	*/
			request.getRequestDispatcher("/getRed.jsp?state=1").forward(request, response);	
		}else{
			/*String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+UseValue.AppId
					+"&redirect_uri=http%3A%2F%2F"+UseValue.Url+"%2FCard%2FRedPackCompanyOAuth&response_type=code"
					+"&scope=snsapi_base&state="+UseValue.AppId+"&component_appid="+UseValue.ComponentAppid+"#wechat_redirect";
			response.sendRedirect(url);*/	
			request.getRequestDispatcher("/getRed.jsp?state=2").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.base.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;




import org.apache.log4j.Logger;

/**
 * 初始化servlet 

 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(InitServlet.class.getName());
	
	public void init() throws ServletException {
//		log.debug("执行了获取access_token");
//		// 启动定时获取access_token的线�?
		new Thread(new TokenThread()).start();
	}
}
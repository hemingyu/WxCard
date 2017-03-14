package com.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WeiXinService {
	public boolean checkSignature(HttpServletRequest request, HttpServletResponse response);
//	public void weiXinManage(HttpServletRequest request, HttpServletResponse response) throws IOException;
}

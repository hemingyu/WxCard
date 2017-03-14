package com.wechat.util;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;


public class UserInfoUtil {
	private static Logger log=Logger.getLogger(UserInfoUtil.class);
	
	public static String getOAuthUserNews="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	public static JSONObject getUserInfo(String accessToken,String openId){
		String requestUrl =getOAuthUserNews.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		JSONObject jsonObject =CommonUtil.httpsRequest(requestUrl, "GET", null);
		return jsonObject;
	}
}

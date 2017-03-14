package com.wechat.util;

import java.text.DecimalFormat;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.base.model.UseValue;
import com.base.model.WeixinOAuth2Token;

public class OAuth2Util {

	private static Logger log=Logger.getLogger(OAuth2Util.class);
	/**
	 * 公众平台代替公众号网页授权凭证
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return
	 */
	public static WeixinOAuth2Token getComponentOAuth2AccessToken(String appId, String code){
		WeixinOAuth2Token wt =null;
		String requestUrl=UseValue.getComponentOAuthAccessToken;
		requestUrl=requestUrl.replace("APPID", appId);
		requestUrl=requestUrl.replace("CODE", code);
		//requestUrl=requestUrl.replace("COMPONENT_APPID", componentAppid);
		requestUrl=requestUrl.replace("COMPONENT_ACCESS_TOKEN", UseValue.componentAccessToken);
		JSONObject jsonObject =CommonUtil.httpsRequest(requestUrl, "GET", null);
		try{
			if(jsonObject!=null){
				wt=new WeixinOAuth2Token();
				wt.setAccessToken(jsonObject.getString("access_token"));
				wt.setExpiresIn(jsonObject.getInt("expires_in"));
				wt.setRefreshToken(jsonObject.getString("refresh_token"));
				wt.setOpenId(jsonObject.getString("openid"));
				wt.setScope(jsonObject.getString("scope"));
			}
			
		}catch(Exception e){
			wt =null;
//			int errorcode=jsonObject.getInt("errcode");
			String errmsg =jsonObject.getString("errmsg");
			log.error("获取网页授权失败:"+errmsg);
		}
		return wt;
		
	}
	/**
	 * 获取商户appid的access_token
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return
	 */
	public static String getOAuth2AccessToken(String appId,String appSecret){
		String accessToken="";
		String requestUrl=UseValue.getTokenUrl;
		requestUrl=requestUrl.replace("APPID", appId);
		requestUrl=requestUrl.replace("APPSECRET", appSecret);
		JSONObject jsonObject =CommonUtil.httpsRequest(requestUrl, "GET", null);
		try{
			if(jsonObject!=null){
				accessToken=jsonObject.getString("access_token");
			}
			
		}catch(Exception e){
			String errmsg =jsonObject.getString("errmsg");
			log.error("获取网页授权失败:"+errmsg);
		}
		return accessToken;
		
	}

	public static String urlEncodeUTF8(String course){
		String result =course;
		try{
			result =java.net.URLEncoder.encode(course,"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	//查看用户是否关注
	public static JSONObject getAttention(String openId, String accessToken) {
		String requestUrl=UseValue.getUserNews;
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		requestUrl=requestUrl.replace("OPENID", openId);
		JSONObject jsonObject =CommonUtil.httpsRequest(requestUrl, "GET", null);
		return jsonObject;
	}
	//发送模板信息企业红包
	public static JSONObject sendTemplate(String openId,int num, String accessToken) {
		String requestUrl=UseValue.sendTemplate;
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		
		float numRedPack=(Float.parseFloat(num+"".toString()))/100;//如果要求精确到两位小数
		
		String url="http://weixin.qq.com/download";
		String jsonMenu="{\"touser\":\""+openId+"\",\"template_id\":\""+UseValue.template_id+"\","
           +"\"url\":\""+url+"\",\"topcolor\":\"#FF0000\",\"data\":{\"first\":{\"value\":\"给您送红包了!\",\"color\":\"#173177\"},"
		   +"\"keyword1\":{\"value\":\"红包,已送往您的钱包\",\"color\":\"#173177\"},"
           +"\"keyword2\":{\"value\":\""+numRedPack+"元\",\"color\":\"#173177\"},\"remark\":{\"value\":\"明天再来领红包吧!\",\"color\":\"#173177\"}}}";
		JSONObject jsonObject =CommonUtil.httpsRequest(requestUrl, "POST", jsonMenu);
		log.info("jsonObject"+jsonObject.getInt("errcode"));
		return jsonObject;
	}
}

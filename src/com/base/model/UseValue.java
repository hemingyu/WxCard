package com.base.model;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.bufoon.action.GeLiPrizeAction;

public class UseValue {
	private static Logger log = Logger.getLogger(UseValue.class);
	//比文科技czhxin平台
	public final static String ComponentAppid = "wx97c759441c370a63";
	public final static String Url = "www.bewin-yao.com";
	public final static String ComponentAppSecret ="0c79e1fa963cd80cc0be99b20a18faeb";
	
	//比文科技
/*	public final static String AppId ="wxa6fc31c47844bfed";
	public final static String AppSecret ="6ce28fd6b5688b4f8920beafb1b4e9af";
	public final static String token ="wo8335224";
	public final static String headImg = "http://wx.qlogo.cn/mmopen/Q3auHgzwzM7PMyRbwXr4zybUnfzHjPaUMsia1bVU0rQVXXYia58wCiaBnx87yRwQJeCRLETEqwINTIeuXacKJQlEnCtnLsw4U1km10ZnEJF3UI/0";
	*/
	public static String userName =null;
	public static String AppId =null;
	public static String templateAppId ="wxa6fc31c47844bfed";//比文科技
	public final static String AppSecret ="4822f69959c52bf269bdd7ebc63683b0";//比文科技
										//比文周边"f4911d7f8f5c7d5e0afdb10dbad50ee1";
	public final static String token ="wo8335224";//可以不要
	public static String headImg = null;
	public static String name = null;
	public static String template_id ="OnZjWElY9BOvZpzRjV-q5-JIz0lVg9qR5YRIjUr3nOE";//比文科技
	
	
	public static String CustAppId =null;
	public static String Status =null;
	//比文周边GDt_yNTTRx0yAPFPJ3tx8osTFO690GVLjLVsGf27oB4;
	//比文周边
	/*public static String AppId ="wx42e0cdd05cff5dd5";
	public final static String AppSecret ="f4911d7f8f5c7d5e0afdb10dbad50ee1";//可以不要
	public final static String token ="wo8335224";//可以不要
	public static String headImg = "http://wx.qlogo.cn/mmopen/CJ35Z2cnZA24zThohT3cvxOh9vwteJysk2P7iahjxc9vxicXPGMTRlKR0hLVxD6icqhGK0nxGHciaYxOXiatacia6p1EV27ujRH015/0";
	public static String name = "比文周边";*/
	//益加菌
	/*public final static String AppId ="wxc1f929e8f1fa3c8a";
	public final static String AppSecret ="b99197d64e68da67b45f88125adbb8b1";
	public final static String token ="1472DBB419662315AAA8D40C6C4776";//可以不要
	public final static String headImg = "http://wx.qlogo.cn/mmopen/v7cibqRjTFRkXUM1RiacLlYZIrialbib1NhPvQbAvVCEhhPS22FGvggvyhCx60iaplOezrxDUQqhjx4ydkzg20DAeOrIGTBeNmOgx/0";
	public final static String name = "益菌加";*/

	
	/*public final static String AppId ="wxdf356f5b85701bd6";
	public final static String AppSecret ="5ec2a63fc7693d3000e043d22c82d05e";*/
//	public final static String getTokenUrl ="https://101.226.90.58/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
//	public final static String creteMenuUrl ="https://101.226.90.58/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
//	public final static String getMenuUrl ="https://101.226.90.58/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
//	public final static String deleteMenuUrl ="https://101.226.90.58/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
//	public final static String uploadUrl ="http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
//	public final static String getUserNews="https://101.226.90.58/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
//	public final static String getUserTable="https://101.226.90.58/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
//	public final static String getCodeUrl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
//	public final static String getOAuthAccessToken="https://101.226.90.58/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
//	public final static String getreferAccessUrl="https://101.226.90.58/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
//	public final static String getOAuthUserNews="https://101.226.90.58/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
//	public final static String isOAuthAccessToken="https://101.226.90.58/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	
//	 * 对于上面的，当你的服务器DNS没有设置等问题，下面的网�?��解析不到的，使用ip可以�?
	public final static String getTokenUrl ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public final static String creteMenuUrl ="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public final static String getMenuUrl ="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	public final static String deleteMenuUrl ="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	public final static String uploadUrl ="http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	//获取用户基本信息(UnionID机制)
	public final static String getUserNews="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public final static String getUserTable="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	public final static String getCodeUrl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	public final static String getreferAccessUrl="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	public final static String getOAuthAccessToken="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	
	public final static String getComponentOAuthAccessToken="https://api.weixin.qq.com/sns/oauth2/component/access_token?appid=APPID&code=CODE&grant_type=authorization_code"
												   + "&component_appid="+ComponentAppid+"&component_access_token=COMPONENT_ACCESS_TOKEN";

	public final static String getOAuthUserNews="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public final static String isOAuthAccessToken="https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	
	public final static String getOAuthUserInfo="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	//jsdk接口
	public final static String getJsApi="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	public final static String cardJsAPIUrl="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=wx_card";
	/**
	 * 获取开放平台token
	 */
	public final static String getComponentToken = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
	/**
	 * 获取（刷新）授权公众号的令牌https:// api.weixin.qq.com /cgi-bin/component/api_authorizer_token?component_access_token=xxxxx
	 */															
	public final static String getAuthorizerAccessToken  = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=TOKEN";
	/**
	 * 发送模板信息
	 */
	public final static String sendTemplate  = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	/**
	 * 
	 * 用户扫码
	 */
	public final static String REDPACKPICURL="http://imgsrc.baidu.com/forum/pic/item/ca1349540923dd54eca97ad9d109b3de9d8248ad.jpg";
	public final static String REDPACKGETURL="http://www.bewin-yao.com/Treasure/getRed.html";
	/**
	 * 用户的AccessToken
	 * 
	 *  获得JS - API Ticket
	 * */
	public static AuthMasterToken access_token = null;
	public static String accessToken = null;
	public static String componentAccessToken = null;
	public static String JSApiTicket = null;
	public static String JSCardTicket = null;
	
	public static String path="";
	public final static String textXML = "<xml>"+
	"<ToUserName><![CDATA[%1$s]]></ToUserName>"+
	"<FromUserName><![CDATA[%2$s]]></FromUserName>"+
	"<CreateTime>%3$s</CreateTime>"+
	"<MsgType><![CDATA[%4$s]]></MsgType>"+
	"<Content><![CDATA[%5$s]]></Content>"+
	"<FuncFlag>0</FuncFlag>"+
	"</xml>"; 
	public final static String imageXML = "<xml>"+
	"<ToUserName><![CDATA[%1$s]]></ToUserName>"+
	"<FromUserName><![CDATA[%2$s]]></FromUserName>"+
	"<CreateTime>%3$s</CreateTime>"+
	"<MsgType><![CDATA[%4$s]]></MsgType>"+
	"<Image><MediaId><![CDATA[%5$s]]></MediaId></Image>"+
	"</xml>";  
	
	public final static String voiceXML = "<xml>"+
	"<ToUserName><![CDATA[%1$s]]></ToUserName>"+
	"<FromUserName><![CDATA[%2$s]]></FromUserName>"+
	"<CreateTime>%3$s</CreateTime>"+
	"<MsgType><![CDATA[%4$s]]></MsgType>"+
	"<Voice>" +
	"<MediaId><![CDATA[%5$s]]></MediaId>" +
	"</Voice>"+
	"</xml>";  
	public final static String videoXML = "<xml>"+
	"<ToUserName><![CDATA[%1$s]]></ToUserName>"+
	"<FromUserName><![CDATA[%2$s]]></FromUserName>"+
	"<CreateTime>%3$s</CreateTime>"+
	"<MsgType><![CDATA[%4$s]]></MsgType>"+
	"<Video>" +
	"<MediaId><![CDATA[%5$s]]></MediaId>" +
	"<Title><![CDATA[%6$s]]></Title>" +
	"<Description><![CDATA[%7$s]]></Description>" +
	"</Video>"+
	"</xml>"; 
	public final static String musicXML = "<xml>"+
	"<ToUserName><![CDATA[%1$s]]></ToUserName>"+
	"<FromUserName><![CDATA[%2$s]]></FromUserName>"+
	"<CreateTime>%3$s</CreateTime>"+
	"<MsgType><![CDATA[%4$s]]></MsgType>"+
	"<Music>" +
	"<Title><![CDATA[%5$s]]></Title>" +
	"<Description><![CDATA[%6$s]]></Description>" +
	"<MusicUrl><![CDATA[%7$s]]></MusicUrl>" +
	"<HQMusicUrl><![CDATA[%8$s]]></HQMusicUrl>" +
	"<ThumbMediaId><![CDATA[%9$s]]></ThumbMediaId>" +
	"</Music>"+
	"</xml>"; 
	public final static String textPicXML = "<xml>"+
	"<ToUserName><![CDATA[%1$s]]></ToUserName>"+
	"<FromUserName><![CDATA[%2$s]]></FromUserName>"+
	"<CreateTime>%3$s</CreateTime>"+
	"<MsgType><![CDATA[%4$s]]></MsgType>" +
	"<ArticleCount>%5$s</ArticleCount>" +
	"<Articles>%6$s" +
	"</Articles>"+
	"</xml>"; 
	public final static String textPicContentXML ="<item>" +
	"<Title><![CDATA[%1$s]]></Title>" +
	"<Description><![CDATA[%2$s]]></Description>" +
	"<PicUrl><![CDATA[%3$s]]></PicUrl>" +
	"<Url><![CDATA[%4$s]]></Url>" +
	"</item>";
	public static String getTime(){
		return new Date().getTime()+"";
	}
	/*
	 *设置项目路径
	**/
	public static void setPath(HttpServletRequest request){
		 String url=request.getSession().getServletContext().getRealPath("/");
		 UseValue.path=url;
	}
	/**
	 * 
//	 * */
	public static String getHeadImg(String url,String dot){
		String[] v=url.split(dot);
		int num=v.length;
		return v[num-1];
	}
	public static void main(String[] args){
		String v=getHeadImg("http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0","/");
		log.info(v);
	}
}

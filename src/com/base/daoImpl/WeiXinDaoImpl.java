package com.base.daoImpl;

import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.base.dao.WeiXinDao;
import com.base.model.AccessToken;
import com.base.model.UseValue;
import com.wechat.method.HttpClientConnectionManager;

/**
 *
 * */
public class WeiXinDaoImpl implements WeiXinDao {
	public static DefaultHttpClient httpclient;
	private static Logger log = Logger.getLogger(WeiXinDaoImpl.class.getName());
//	private static UserService userService = null;
//	private static MemberService memberService = null;
	static {
//		userService = (UserService) ac.getBean("userService");
//		memberService = (MemberService) ac.getBean("memberService");
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager
				.getSSLInstance(httpclient);
	}
	/**
	 * 获取accessToken
	 */
	public AccessToken getAccessToken(String appid, String secret)
			throws Exception {
		String tokenUrl = UseValue.getTokenUrl.replace("APPID", appid).replace(
				"APPSECRET", secret);
		log.info("tokenUrl Value:" + tokenUrl);
		//https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd764cac960756f32&secret=1ebe981e0c63490e1f8984f78da76e57
		URL url = new URL(tokenUrl);
		URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
		HttpGet httpget = new HttpGet(uri);
//		HttpGet get = HttpClientConnectionManager.getGetMethod(tokenUrl);
		HttpResponse response = httpclient.execute(httpget);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		AccessToken accessToken = new AccessToken();
		accessToken.setToken(jsonObject.getString("access_token"));
		accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
		return accessToken;
	}


	// sha1加密
	protected String SHA1Encode(String sourceString) {
		String resultString = null;
		try {
			resultString = new String(sourceString);
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			resultString = byte2hexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
		}
		return resultString;
	}

	protected final String byte2hexString(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		// return buf.toString().toUpperCase();
		return buf.toString().toLowerCase();
	}

	public static void main(String[] args) throws Exception {

		WeiXinDaoImpl dao = new WeiXinDaoImpl();
		AccessToken ac = dao.getAccessToken(UseValue.AppId, UseValue.AppSecret);
		log.info(ac.getToken());
		/*
		 * log.info(ac.getExpiresIn());
		 *//********************************* 增加菜单�?�� ************************/
		/*
		 * Stringmenu=
		 * "{\"button\":[{\"type\":\"view\",\"name\":\"主页\",\"url\":\"http://www.zhuangtaowang.com/1/4.html\"},{\"type\":\"click\",\"name\":\"菜单\",\"key\":\"1\"},{\"type\":\"view\",\"name\":\"会员查询\",\"url\":\"http://www.zhuangtaowang.com/1/h1.html\"}]}"
		 * ;
		 * 
		 * String result=dao.createMenu(menu,ac.getToken());
		 * log.info(result);
		 */
		/********************************* 增加菜单结束 ************************/

		/********************************* 删除菜单�?�� ************************/
		/*
		 * String result=dao.deleteMenu(ac.getToken());
		 * log.info(result);
		 */
		/********************************* 删除菜单结束 ************************/

	}
}

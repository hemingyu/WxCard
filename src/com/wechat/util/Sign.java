package com.wechat.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import com.base.model.AccessToken;
import com.base.model.AuthMasterToken;
import com.base.model.UseValue;

public class Sign {
	private static Logger log=Logger.getLogger(Sign.class);
	/**
	 * 
	 * @param api_ticket 卡券API-ticket
	 * @param timestamp  时间戳  ！！必须与JS-API的时间戳一直 即下面的方法sign
	 * @param card_id	 卡券Id
	 * @return
	 * @throws Exception
	 */
    public static String getSignature(String api_ticket,String timestamp,String card_id) throws Exception{
        log.info("卡券票："+api_ticket);
        log.info("卡券时间戳："+timestamp);
        log.info("卡券ID："+card_id);
        ArrayList<String> m_param_to_sign =new ArrayList<String>();
        m_param_to_sign.add(api_ticket);
        m_param_to_sign.add(timestamp);
        m_param_to_sign.add(card_id);
        Collections.sort(m_param_to_sign);
        StringBuilder string_to_sign = new StringBuilder();
        for (String str : m_param_to_sign)
        {
            string_to_sign.append(str);
        }
        log.info("string_to_sign:" + string_to_sign);
        try
        {
            MessageDigest hasher = MessageDigest.getInstance("SHA-1");
            byte[] digest = hasher.digest(string_to_sign.toString().getBytes());
            return ByteToHexString(digest);
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return "";
        }
    }
    public static String ByteToHexString(byte[] data)
    {
        StringBuilder str = new StringBuilder();
        for (byte b : data)
        {
            String hv = Integer.toHexString(b & 0xFF); 
            if( hv.length() < 2 )
                str.append("0");
            str.append(hv);
        }
        return str.toString();
    }
    
    /**
     * 获得JS - API Ticket
     * @param appid
     * @return
     */
    public static String getJsApiTicket(String appid){
    	String apiTicket = ComponentUtil.getComponentJsTicket(appid);
    	return apiTicket;
    }
/*    public static String getJsApiTicket(String appid){
    	AuthMasterToken accessToken = ComponentUtil.getAuthMasterToken(appid);
    	return ComponentUtil.getComponentJsTicket(accessToken, appid);
    }*/
    /**
     * 获得卡券JS-Card ticket
     * @param appid
     * @return
     */
    public static String getCardTicket(String appid){
    	String cardTicket = ComponentUtil.getComponentCardJsTicket(appid);
    	return cardTicket;
    }
    /*public static String getCardTicket(String appid){
    	AuthMasterToken accessToken = ComponentUtil.getAuthMasterToken(appid);
    	return ComponentUtil.getComponentCardJsTicket(accessToken, appid);
    }*/
    /**
     * 获得JS - API Ticket
     * @param appid
     * @return
     */
/*    public static String getJsApiTicket(String appid){
    	log.info("进入获得JSAPITicket");
    	AccessToken accessToken = UseValue.accessToken;
    	String ticket=null;
		ticket = CommonUtil.getWechatJSToken(accessToken.getToken());
		return ticket;
    }*/
    /**
     * 获得卡券JS-Card ticket
     * @param appid
     * @return
     */
  /*  public static String getCardTicket(String appid){
    	log.info("进入获得JSCardTicket");
    	AccessToken accessToken = UseValue.accessToken;
    	String ticket=null;
		ticket = CommonUtil.getCardJSToken(accessToken.getToken());
		return ticket;
    }*/
    /**
     * 调用微信JS-API 签名
     * @param url   调用微信API的当前网页.必须在JS动态获取。
     * 确保你获取用来签名的url是动态获取的，动态页面可参见实例代码中php的实现方式。
     * 如果是html的静态页面在前端通过ajax将url传到后台签名，
     * 前端需要用js获取当前页面除去'#'hash部分的链接
     * （可用location.href.split('#')[0]获取,而且需要encodeURIComponent），
     * 因为页面一旦分享，微信客户端会在你的链接末尾加入其它参数
     * ，如果不是动态获取当前链接，将导致分享后的页面签名失败。
     * 
     * @param appid 授权公众号appid 不是比文平台的
     * @return
     */
    public static Map<String, String> sign(String url,String appid) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str(16);
        String string1;
        String timestamp=create_timestamp();
        String signature = "";
        String jsapi_ticket= getJsApiTicket(appid);
        //getJsApiTicket(appid);
        
        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" +url;
        log.info("签名字符串"+string1);
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
            log.info("签名中的signature"+signature);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        log.info("JSAPI卡券Ticket"+jsapi_ticket);
        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }
    /**
     *  签名
     * @param hash
     * @return
     */
    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    /**
     * 生成随机字符串
     * @param n
     * @return
     */
    public static String create_nonce_str(int n) {
    	  StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");   
          StringBuffer sb = new StringBuffer();   
          Random random = new Random();   
          int range = buffer.length();   
          for (int i = 0; i < n; i ++) {   
              sb.append(buffer.charAt(random.nextInt(range)));   
          }   
          return sb.toString();   
    }
    /**
     * 生成时间戳
     * @return
     */
    public static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
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
}

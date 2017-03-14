package com.base.servlet;

import com.base.daoImpl.WeiXinDaoImpl;
import com.base.model.ComponentToken;
import com.base.model.UseValue;
import com.wechat.util.ComponentUtil;
import com.wechat.util.OAuth2Util;

import org.apache.log4j.Logger;
/**
 * 定时获取微信access_token的线�?
 */
public class TokenThread implements Runnable {
	private static Logger log = Logger.getLogger(TokenThread.class.getName());
	public static WeiXinDaoImpl dao=new WeiXinDaoImpl();
	
	public void run() {
		Boolean result = true;
		while (result) {
			try {
				log.info("Card进入线程循环");
				//更新平台的access_token
				ComponentToken componentToken = ComponentUtil.getComponentToken();
				String componentAccessToken = componentToken.getToken();
				
//				log.info("UseValue.accessToken:"+UseValue.accessToken+";    "+UseValue.accessToken.getToken());
				if (null != componentAccessToken) {
					UseValue.componentAccessToken=componentAccessToken;
					//UseValue.accessToken=OAuth2Util.getOAuth2AccessToken(UseValue.templateAppId,UseValue.AppSecret);
					//不需要Yao平台去获取，只要Yao平台获取到票据就可以了，由Card项目每隔6000秒拿票据去自动获取
					//更新公众号的access_token,公众号的jsApiticket,公众号的JsCardticket,
					//ComponentUtil.getAuthMasterTokenWant();
					
					//log.debug("获取access_token成功，有效时长{"+accessToken.getExpiresIn()+"}�?token:{"+accessToken.getToken()+"}");
					log.info("componentToken.getExpiresIn()11111111:"+componentToken.getExpiresIn());
					Thread.sleep((componentToken.getExpiresIn()-190) * 1000);	
				} else{
					// 如果access_token为null10秒后再获�?
					log.info("平台的accesstoken过期，请重新获取");
					Thread.sleep(100 * 1000);
				}
			}catch (Exception e) {
				log.error("{}", e);
			}
		}
	}
}
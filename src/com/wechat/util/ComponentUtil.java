package com.wechat.util;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.base.model.ComponentToken;
import com.base.model.UseValue;
import com.bufoon.entity.ComponentAccessToken;
import com.bufoon.entity.QueryAuthMaster;
import com.bufoon.service.ComponentAccessTokenService;
import com.bufoon.service.QueryAuthMasterService;


@Transactional
public class ComponentUtil {
	private static Logger log = Logger.getLogger(ComponentUtil.class);
	//private static ComponentVerifyTicketService componentVerifyTicketService;
	private static ComponentAccessTokenService componentAccessTokenService;
	private static QueryAuthMasterService queryAuthMasterService;
	//private static AuthorizerInfoService authorizerInfoService;
	static {
		@SuppressWarnings("resource")
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		//componentVerifyTicketService = (ComponentVerifyTicketService) factory.getBean("componentVerifyTicketService");
		componentAccessTokenService = (ComponentAccessTokenService) factory.getBean("componentAccessTokenService");
		queryAuthMasterService = (QueryAuthMasterService) factory.getBean("queryAuthMasterService");
		//authorizerInfoService = (AuthorizerInfoService) factory.getBean("authorizerInfoService");
	}
	/*
	 * 初始化时更新公众号的access_token,公众号的jsApiticket,公众号的JsCardticket,
	 * 
	 */
/*	public static void getAuthMasterTokenWant() {
		String tokensql = "from QueryAuthMaster where recordStatus =0";
		List<QueryAuthMaster> masterList = queryAuthMasterService.findAllList(tokensql);
		if(masterList!=null){
			for(QueryAuthMaster master:masterList){
				String refeshToken = master.getAuthorizerRefreshToken();
				
				 更新公众号的access_token用微信服务器用已有的refeshToken 重新获取authtoken 				
				AuthMasterToken newToken = CommonUtil.getRefeshAuthMasterToken(master.getAppid(), refeshToken);			
				if (newToken != null) {
					 更新保存数据库中已经有的最的token并且设置当前时间 
					master.setAuthorizerAccessToken(newToken.getToken());
					master.setAuthorizerRefreshToken(newToken.getRefeshToken());
					master.setTokenStartTime(new Timestamp(System.currentTimeMillis()));
					
					//初始化时更新公众号的jsApiticket
					String jsApiTicket = CommonUtil.getWechatJSToken(master.getAuthorizerAccessToken());
					if (jsApiTicket != null) {
					 更新保存数据库中已经有的最的token并且设置当前时间 
						master.setJsApiTicketStartTime(new Timestamp(System.currentTimeMillis()));
						master.setJsApiTicket(jsApiTicket);
					}
					
					//初始化时更新公众号的JsCardticket
					String cardTicket = CommonUtil.getCardJSToken(master.getAuthorizerAccessToken());
				    获取成功更新数据库
					if (cardTicket != null) {
					 更新保存数据库中已经有的最的token并且设置当前时间 
						master.setCardJsTicketStartTime(new Timestamp(System.currentTimeMillis()));
						master.setCardJsTicket(cardTicket);
					}
					queryAuthMasterService.updateQueryAuthMaster(master);
				}else{
					master.setRecordStatus(1);
					master.setDeleteTime(new Timestamp(System.currentTimeMillis()));
					queryAuthMasterService.updateQueryAuthMaster(master);
					AuthorizerInfoMaster authorizerInfo=authorizerInfoService.getAuthorizerInfoMatser("select * from d_authorizer_info where appid='"+master.getAppid()+"'");
					authorizerInfo.setRecordStatus(1);
					authorizerInfoService.updateAuthorizerInfoMaster(authorizerInfo);
				}
			}
		}
	}
	public static ComponentToken commonGetComponentToken() {
		String accesssql = "select * from t_component_access where appid ='" + UseValue.ComponentAppid + "'";
		ComponentAccessToken componentAccessToken = componentAccessTokenService.getComponentAccessToken(accesssql);
		ComponentToken returnToken = new ComponentToken();
		returnToken.setToken(componentAccessToken.getComponentAccessToken());
		return returnToken;
	}
	*/
	/**
	 * 获得JS API 权限
	 * @param token
	 * @param appid
	 * @return
	 */
	public static String getComponentJsTicket(String appid){
		log.info("进入获得JSAPITicket");
		String ticket=null;
		if(appid!=null){
			String tokensql = "select * from y_query_auth where authorizer_appid = '" + appid + "' and record_status ='0'";
			QueryAuthMaster master = queryAuthMasterService.getQueryAuthMaster(tokensql);
			if (master != null && master.getJsApiTicket()!=null) {
					ticket= master.getJsApiTicket();
					return ticket;
			
				}
		}
		return ticket;
	}
	/*public static String getComponentJsTicket(AuthMasterToken token,String appid){
		log.info("进入获得JSAPITicket");
		String ticket=null;
		if(token!=null){
			String tokensql = "select * from d_query_auth where authorizer_appid = '" + appid + "' and record_status ='0'";
			QueryAuthMaster master = queryAuthMasterService.getQueryAuthMaster(tokensql);
			 如果数据库存在JSticket判断是否过期
			if (master != null && master.getJsApiTicket()!=null) {
				Timestamp startTime = master.getJsApiTicketStartTime();
				Long l_times = startTime.getTime();
				if ((System.currentTimeMillis() - l_times) / 1000 < 7200) {
					ticket= master.getJsApiTicket();
					return ticket;
					否则就重新获取JSToken
				} else {
					 重新获取JSToken 
					 ticket = CommonUtil.getWechatJSToken(token.getToken());
					 获取成功更新数据库
					if (ticket != null) {
						 更新保存数据库中已经有的最的token并且设置当前时间 
						master.setJsApiTicketStartTime(new Timestamp(System.currentTimeMillis()));
						master.setJsApiTicket(ticket);
						queryAuthMasterService.updateQueryAuthMaster(master);
						return ticket;
					}
				}
				如果数据库不存在，就直接重新获取
			}else{
				 重新获取JSToken 
				 ticket = CommonUtil.getWechatJSToken(token.getToken());
				if (ticket != null) {
					 更新保存数据库中已经有的最的token并且设置当前时间 
					master.setJsApiTicketStartTime(new Timestamp(System.currentTimeMillis()));
					master.setJsApiTicket(ticket);
					queryAuthMasterService.updateQueryAuthMaster(master);
					return ticket;
				}
			}
			
			
		}
		return null;
	}*/
	/**
	 * 获得JS CARD API权限
	 * @param token
	 * @param appid
	 * @return
	 */
	public static String getComponentCardJsTicket(String appid){
		String ticket=null;
		log.info("进入获得JSTicket");
		if(appid!=null){
			String tokensql = "select * from y_query_auth where authorizer_appid = '" + appid + "' and record_status ='0'";
			QueryAuthMaster master = queryAuthMasterService.getQueryAuthMaster(tokensql);
			if (master != null && master.getCardJsTicket()!=null) {
					ticket= master.getCardJsTicket();
					return ticket;
				} 
		}
		return ticket;
	}
	/*public static String getComponentCardJsTicket(AuthMasterToken token,String appid){
		String ticket=null;
		log.info("进入获得JSTicket");
		if(token!=null){
			String tokensql = "select * from d_query_auth where authorizer_appid = '" + appid + "' and record_status ='0'";
			QueryAuthMaster master = queryAuthMasterService.getQueryAuthMaster(tokensql);
			 如果数据库存在JSticket判断是否过期
			if (master != null && master.getCardJsTicket()!=null) {
				Timestamp startTime = master.getCardJsTicketStartTime();
				Long l_times = startTime.getTime();
				if ((System.currentTimeMillis() - l_times) / 1000 < 7200) {
					ticket= master.getCardJsTicket();
					return ticket;
					否则就重新获取JSToken
				} else {
						 重新获取JSToken 
						 ticket = CommonUtil.getCardJSToken(token.getToken());
						 获取成功更新数据库
						if (ticket != null) {
							 更新保存数据库中已经有的最的token并且设置当前时间 
							master.setCardJsTicketStartTime(new Timestamp(System.currentTimeMillis()));
							master.setCardJsTicket(ticket);
							queryAuthMasterService.updateQueryAuthMaster(master);
							return ticket;
						}
				}
				如果数据库不存在，就直接重新获取
			}else{
				 重新获取JSToken 
				 ticket = CommonUtil.getCardJSToken(token.getToken());
				if (ticket != null) {
					 更新保存数据库中已经有的最的token并且设置当前时间 
					master.setCardJsTicketStartTime(new Timestamp(System.currentTimeMillis()));
					master.setCardJsTicket(ticket);
					queryAuthMasterService.updateQueryAuthMaster(master);
					return ticket;
				}
			}
			
			
		}
		return null;
	}*/
	/**
	 * 公众号的authorizer_access_token 授权公众号令牌
	 * 与普通公众号Accesstoken一样
	 * @return
	 */
	/*public static AuthMasterToken getAuthMasterToken(String appid) {
		log.info("进入获得授权accesstoken");
		AuthMasterToken matserToken = null;
		if (appid != null) {
			String tokensql = "select * from d_query_auth where authorizer_appid = '" + appid + "' and record_status ='0'";
			QueryAuthMaster master = queryAuthMasterService.getQueryAuthMaster(tokensql);
			if (master != null) {
				Timestamp startTime = master.getTokenStartTime();
				Long l_times = startTime.getTime();
				if (((System.currentTimeMillis() - l_times) / 1000 < 7200)&&master.getAuthorizerAccessToken()!=null) {
					matserToken = new AuthMasterToken();
					matserToken.setToken(master.getAuthorizerAccessToken());
					return matserToken;
				} else {
					matserToken = new AuthMasterToken();
					String refeshToken = master.getAuthorizerRefreshToken();
					// 微信服务器用已有的refeshToken 重新获取authtoken 				
					AuthMasterToken newToken = CommonUtil.getRefeshAuthMasterToken(appid, refeshToken);			
					if (newToken != null) {
					//	 更新保存数据库中已经有的最的token并且设置当前时间 
						master.setAuthorizerAccessToken(newToken.getToken());
						master.setAuthorizerRefreshToken(newToken.getRefeshToken());
						master.setTokenStartTime(new Timestamp(System.currentTimeMillis()));
						queryAuthMasterService.updateQueryAuthMaster(master);
						matserToken.setToken(newToken.getToken());
						return matserToken;
					}
				}
			}
		}
		return null;
	}
*/
	/**
	 * 获得更新平台AccessToken
	 *
	 * @return
	 */
	public static ComponentToken getComponentToken() {
		String accesssql = "select * from y_component_accesstoken where appid ='" + UseValue.ComponentAppid + "'";
		//String ticketSql = "select * from t_component_verify_ticket where appid ='" + UseValue.ComponentAppid + "'";
		ComponentAccessToken componentAccessToken = componentAccessTokenService.getComponentAccessToken(accesssql);
		ComponentToken returnToken = null;
		log.info("componentAccessToken"+componentAccessToken.getComponentAccessToken());
		if (componentAccessToken != null) {
			Timestamp startTime = componentAccessToken.getComponentTokenStartTime();
			Long l_times = startTime.getTime();
			Long remain_time =(System.currentTimeMillis() - l_times) / 1000;
			/** 判断是否有效 用当前时间去比较（7200秒）*/
			/*if (componentAccessToken.getComponentAccessToken()!=null&&(remain_time < componentAccessToken.getComponentTokenExpiresIn())) {*/
			returnToken = new ComponentToken();
			returnToken.setToken(componentAccessToken.getComponentAccessToken());
			//再次刷新平台access_token的剩余时间
			returnToken.setExpiresIn(7200-remain_time.intValue());
			return returnToken;
			/*}*//* else {
				*//** 如果无效就重新获取 *//*
				
				  拿到微信服务器推送的ComponentVerifyTicket获取Token不需要去判断是否过期
				 
				ComponentVerifyTicket ticket = componentVerifyTicketService.getComponentVerifyTicket(ticketSql);
				returnToken = CommonUtil.getComponentToken(UseValue.ComponentAppid, UseValue.ComponentAppSecret, ticket.getComponentVerifyTicket());
				componentAccessToken.setComponentAccessToken(returnToken.getToken());
				componentAccessToken.setComponentTokenStartTime(new Timestamp(System.currentTimeMillis()));
				componentAccessTokenService.updateComponentAccessToken(componentAccessToken);
				return returnToken;
			//}
*/		}
		return null;
	}
	/**
	 * 获得更新平台AccessToken
	 *每次自己去获取，不用平台自动获取
	 * @return
	 */
	/*public static ComponentToken getComponentToken() {
		String accesssql = "select * from t_component_access where appid ='" + UseValue.ComponentAppid + "'";
		String ticketSql = "select * from t_component_verify_ticket where appid ='" + UseValue.ComponentAppid + "'";
		ComponentAccessToken componentAccessToken = componentAccessTokenService.getComponentAccessToken(accesssql);
		ComponentToken returnToken = null;
		log.info("componentAccessToken"+componentAccessToken);
		if (componentAccessToken != null) {
			//Timestamp startTime = componentAccessToken.getComponentTokenStartTime();
			//Long l_times = startTime.getTime();
			*//** 判断是否有效 用当前时间去比较（7200秒）*//*
			if (componentAccessToken.getComponentAccessToken()!=null&&((System.currentTimeMillis() - l_times) / 1000 < componentAccessToken.getComponentTokenExpiresIn())) {
				returnToken = new ComponentToken();
				returnToken.setToken(componentAccessToken.getComponentAccessToken());
				returnToken.setExpiresIn(componentAccessToken.getComponentTokenExpiresIn());
				return returnToken;
			} else {
				*//** 如果无效就重新获取 *//*
				
				 * 拿到微信服务器推送的ComponentVerifyTicket获取Token不需要去判断是否过期
				 
				ComponentVerifyTicket ticket = componentVerifyTicketService.getComponentVerifyTicket(ticketSql);
				returnToken = CommonUtil.getComponentToken(UseValue.ComponentAppid, UseValue.ComponentAppSecret, ticket.getComponentVerifyTicket());
				componentAccessToken.setComponentAccessToken(returnToken.getToken());
				componentAccessToken.setComponentTokenStartTime(new Timestamp(System.currentTimeMillis()));
				componentAccessTokenService.updateComponentAccessToken(componentAccessToken);
				return returnToken;
			//}
		}
		return null;
	}*/

}

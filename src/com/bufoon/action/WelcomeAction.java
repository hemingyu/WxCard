package com.bufoon.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.base.model.UseValue;
import com.base.model.WeixinOAuth2Token;
import com.bufoon.entity.ActiveMaster;
import com.bufoon.entity.AuthorizerInfoMaster;
import com.bufoon.entity.StoresInfo;
import com.bufoon.entity.UserInfoMaster;
import com.bufoon.service.ActiveService;
import com.bufoon.service.AuthorizerInfoService;
import com.bufoon.service.StoresService;
import com.bufoon.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.wechat.util.OAuth2Util;
import com.wechat.util.UserInfoUtil;

public class WelcomeAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
	@Resource
    private StoresService storesService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private AuthorizerInfoService authorizerInfoService;
    @Resource
    private ActiveService activeService;

    private StoresInfo storesInfo;
    
    public StoresInfo getStoresInfo() {
		return storesInfo;
	}
	public void setStoresInfo(StoresInfo storesInfo) {
		this.storesInfo = storesInfo;
	}
	private String oauthId;
	
	public String getOauthId() {
		return oauthId;
	}
	public void setOauthId(String oauthId) {
		this.oauthId = oauthId;
	}
	private static Logger log = Logger.getLogger(WelcomeAction.class);
    
  //用户已经授权可以不用授权就进入导航页
    public String welcome() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
		String code=(String)request.getParameter("code");
		WeixinOAuth2Token weixinOauth2Token = OAuth2Util.getComponentOAuth2AccessToken(UseValue.AppId, code);
		
		AuthorizerInfoMaster  authorizerInfoMaster=authorizerInfoService.getAuthorizerInfoMatser("select * from y_authorizer_info where record_status=0 and appid='"+UseValue.CustAppId+"'");
		UseValue.headImg=authorizerInfoMaster.getHeadImg();
		UseValue.name=authorizerInfoMaster.getNickName();
		UseValue.userName=authorizerInfoMaster.getUserName();

		if(weixinOauth2Token==null||"".equals(weixinOauth2Token)){
			return ERROR;
		}
		String openId = weixinOauth2Token.getOpenId();
		request.getSession().setAttribute("openId", openId);
		log.info("openId2222222222"+openId);
		UserInfoMaster userInfo=userInfoService.getUserInfoMaster("select * from c_userinfo where openid = '"+openId+"' and appid='"+UseValue.CustAppId+"'");
		if(userInfo!=null){
				return SUCCESS;
		}else{
			oauthId="OAUthId";
			return "OAuth";
		}
    }
    //用户需要授权才能进入导航页
	public void welcomeAuth() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String success =null;
		JSONArray json = new JSONArray();
		String code=(String)request.getParameter("code");
		WeixinOAuth2Token weixinOauth2Token = OAuth2Util.getComponentOAuth2AccessToken(UseValue.AppId, code);
		
		AuthorizerInfoMaster  authorizerInfoMaster=authorizerInfoService.getAuthorizerInfoMatser("select * from y_authorizer_info where record_status=0 and appid='"+UseValue.CustAppId+"'");
		UseValue.headImg=authorizerInfoMaster.getHeadImg();
		UseValue.name=authorizerInfoMaster.getNickName();
		UseValue.userName=authorizerInfoMaster.getUserName();	

		if(weixinOauth2Token==null||"".equals(weixinOauth2Token)){
			success ="{'result': 'sorry'}";
			json.add(success);
			response.getWriter().print(json.toString());
			return;
		}
		String accessToken = weixinOauth2Token.getAccessToken();
		String openId = weixinOauth2Token.getOpenId();
		request.getSession().setAttribute("openId", openId);
		
		UserInfoMaster userinfo = getUserInfo(accessToken, openId);
		if (userinfo != null) {
			success ="{'result': 'start'}";
		}
		json.add(success);
		response.getWriter().print(json.toString());
    }

	public UserInfoMaster getUserInfo(String accessToken,String openId){
		JSONObject jsonObject = UserInfoUtil.getUserInfo(accessToken, openId);
		UserInfoMaster userInfo =null;
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		ActiveMaster active = activeService.getActiveMaster("select * from y_active where appid='"+UseValue.CustAppId+"'");
		try{
			if(null!=jsonObject){
				userInfo=new UserInfoMaster();
				UserInfoMaster userInfo1 = new UserInfoMaster();
				String openid = jsonObject.getString("openid");
				userInfo1=userInfoService.getUserInfoMaster("select * from c_userinfo where openid = '"+openid+"' and appid='"+UseValue.CustAppId+"'");

				if(userInfo1!=null&&!"".equals(userInfo1)){
					return userInfo1;
				}else{
					userInfo.setAppid(UseValue.CustAppId);
					userInfo.setOpenid(openid);
					userInfo.setCountry(jsonObject.getString("country"));
					userInfo.setProvince(jsonObject.getString("province"));
					userInfo.setCity(jsonObject.getString("city"));
					if("".equals(jsonObject.getString("headimgurl"))){
						userInfo.setHeadimgurl(jsonObject.getString("http://wx.qlogo.cn/mmopen/qician8qUxrBrucD9oHSqbvMfyhr3tBxWSjO73SZ3icgmpZN5XzOvIU2aiatMDNq3uyWpIjeyxIU5sAzEpaDzvZ8LFVtib5z9Mw2ib/0"));
					}else{
						userInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
					}
					userInfo.setNickname(jsonObject.getString("nickname"));
					Integer sex = (jsonObject.getInt("sex"));
					userInfo.setSex(sex.toString());
					userInfo.setCreateTime(currentTime);
					userInfo.setUpdateTime(currentTime);
					userInfo.setSharkNo(active.getLotteryNumber().toString());
					userInfo.setLog1("0");	
					try{
						userInfo.setUnionid(jsonObject.getString("unionid"));
				    } catch(Exception e){
				    	userInfo.setUnionid("");
				    	//userInfo.setNickname(new String(jsonObject.getString("nickname").getBytes("UTF-8")));
				    	//userInfo.setNickname(jsonObject.getString("nickname").getBytes("UTF-8").toString());	
				    }
					userInfoService.saveUserInfoMaster(userInfo);
				}
			}
		}catch(Exception e){
			String errmsg =jsonObject.getString("errmsg");
			log.error("获取用户信息失败:"+errmsg);
		}
		return userInfo;
	}
	// 获取用户资料失败
	public String weixinOauth() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		storesInfo = storesService.getStoresInfo("select * from y_stores where appid = '" + UseValue.CustAppId+ "' limit 1");
		if (storesInfo != null){
		    request.setAttribute("storesInfo", storesInfo);
		    return "sorry";
		}
		 return "sorry";
	}
	
	// 获取用户信息
	public String getUserInfo() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String openId=(String)request.getSession().getAttribute("openId");
		UserInfoMaster userInfo=userInfoService.getUserInfoMaster("select * from c_userinfo where openid = '"+openId+"' and appid='"+UseValue.CustAppId+"'");
		if(userInfo==null||"".equals(userInfo)){
			storesInfo = storesService.getStoresInfo("select * from y_stores where appid = '" + UseValue.CustAppId+ "' limit 1");
			if (storesInfo != null){
			    request.setAttribute("storesInfo", storesInfo);
			    return "sorry";
			}
		}
	    request.setAttribute("userInfo", userInfo);
	    return SUCCESS;
	}
	// 获取用户资料失败
	public void saveShare() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String openid = (String)request.getSession().getAttribute("openId");
		if (openid != null){
			UserInfoMaster userInfo=userInfoService.getUserInfoMaster("select * from c_userinfo where openid = '"+openid+"' and appid='"+UseValue.CustAppId+"'");
			if(userInfo.getLog2()!=null){
				Integer i = Integer.parseInt(userInfo.getLog2())+1;
				userInfo.setLog2(i.toString());
			}else{
				userInfo.setLog2("1");
			}
			userInfoService.updateUserInfoMaster(userInfo);
		}
	}
}

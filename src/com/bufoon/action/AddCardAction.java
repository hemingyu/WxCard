package com.bufoon.action;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.base.model.UseValue;
import com.bufoon.entity.ActiveCardsMaster;
import com.bufoon.entity.UserCardInfo;
import com.bufoon.entity.UserInfoMaster;
import com.bufoon.service.ActiveCardsService;
import com.bufoon.service.UserCardInfoService;
import com.bufoon.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class AddCardAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    @Resource
    private ActiveCardsService activeCardsService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserCardInfoService userCardInfoService;
    private static Logger log = Logger.getLogger(AddCardAction.class);
    
    private ActiveCardsMaster cardInfo;
    
    public void addUserCardInfo() throws Exception{
	HttpServletRequest request = ServletActionContext.getRequest();
	request.setCharacterEncoding("utf-8");
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setCharacterEncoding("utf-8");
	
	String openId = request.getParameter("openId");
	String cardId = request.getParameter("cardId");
	
	log.info("openId="+openId+",,,,,,,,,cardid="+cardId);
	
	cardInfo = activeCardsService.getActiveCardsMaster("select * from y_activecards where card_id = '" + cardId+ "' and chose_appid='"+UseValue.CustAppId+"'");
	if (cardInfo != null){
	    UserCardInfo user = userCardInfoService.getUserCardInfo("select * from c_usercardinfo where openid = '" + openId+ "'");
	    if (user != null){
		user.setCardtitle(cardInfo.getCardTitle());
		user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		userCardInfoService.updateUserCardInfo(user);
	    } else {
		saveUserCardInfo(openId);
	    }
	}

	
    }

    private void saveUserCardInfo(String openId) {
	// TODO Auto-generated method stub
	UserCardInfo user = new UserCardInfo();
	UserInfoMaster userInfo = userInfoService.getUserInfoMaster("select * from c_userinfo where openid = '" + openId+ "'");
	Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	if(userInfo != null){
	    user.setCardtitle(cardInfo.getCardTitle());
	    user.setClickNo(0);
	    user.setCreateTime(currentTime);
	    user.setHeadimgurl(userInfo.getHeadimgurl());
	    user.setNickname(userInfo.getNickname());
	    user.setOpenId(openId);
	    user.setUnionid(userInfo.getUnionid());
	    user.setUpdateTime(currentTime);
	    userCardInfoService.saveUserCardInfo(user);
	}
    }
}

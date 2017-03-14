package com.bufoon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="c_usercardinfo")
public class UserCardInfo {
	private Integer bewinId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String openid;
	private String nickname;
	private String headimgurl;
	private String unionid;
	private Integer clickNo;
	private String cardtitle;
	private String appId;
	
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "bewin_id", length=11)
	public Integer getBewinId() {
		return bewinId;
	}
	public void setBewinId(Integer bewinId) {
		this.bewinId = bewinId;
	}
	@Column(name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Column(name = "update_time")
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "openid")
	public String getOpenId() {
		return openid;
	}
	public void setOpenId(String openid) {
		this.openid = openid;
	}
	
	@Column(name = "nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Column(name = "headimgurl")
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	@Column(name = "unionid")
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	@Column(name = "click_no")
	public Integer getClickNo() {
		return clickNo;
	}
	public void setClickNo(Integer clickNo) {
		this.clickNo = clickNo;
	}
	@Column(name = "cardtitle")
	public String getCardtitle() {
		return cardtitle;
	}
	public void setCardtitle(String cardtitle) {
		this.cardtitle = cardtitle;
	}
	@Column(name = "appid")
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
}

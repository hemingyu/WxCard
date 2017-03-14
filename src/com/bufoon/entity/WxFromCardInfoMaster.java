package com.bufoon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="y_wxfromcardinfo")
public class WxFromCardInfoMaster {
	private Integer bewinId;
	private Timestamp createTime;
	private String cardId;
	private String appid;
	private String openid;
	private String getCard;
	private String delCard;
	private String useCard;
	private String giveCard;
	private String giveOpenid;
	private String userCardCode;
	private String log1;
	private String log2;
	
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
	@Column(name = "card_id")
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	@Column(name = "appid")
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	@Column(name = "openid")
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column(name = "get_card")
	public String getGetCard() {
		return getCard;
	}
	public void setGetCard(String getCard) {
		this.getCard = getCard;
	}
	@Column(name = "del_card")
	public String getDelCard() {
		return delCard;
	}
	public void setDelCard(String delCard) {
		this.delCard = delCard;
	}
	@Column(name = "use_card")
	public String getUseCard() {
		return useCard;
	}
	public void setUseCard(String useCard) {
		this.useCard = useCard;
	}
	@Column(name = "give_card")
	public String getGiveCard() {
		return giveCard;
	}
	public void setGiveCard(String giveCard) {
		this.giveCard = giveCard;
	}
	@Column(name = "give_openid")
	public String getGiveOpenid() {
		return giveOpenid;
	}
	public void setGiveOpenid(String giveOpenid) {
		this.giveOpenid = giveOpenid;
	}
	@Column(name = "user_card_code")
	public String getUserCardCode() {
		return userCardCode;
	}
	public void setUserCardCode(String userCardCode) {
		this.userCardCode = userCardCode;
	}
	@Column(name = "log1")
	public String getLog1() {
		return log1;
	}
	public void setLog1(String log1) {
		this.log1 = log1;
	}
	@Column(name = "log2")
	public String getLog2() {
		return log2;
	}
	public void setLog2(String log2) {
		this.log2 = log2;
	}


}

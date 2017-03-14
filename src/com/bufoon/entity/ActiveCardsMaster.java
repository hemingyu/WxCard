package com.bufoon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="y_activecards")
public class ActiveCardsMaster {
	private Integer bewinId;
	private Timestamp createTime;
	private Timestamp deteleTime;
	private String cardId;
	private String choseAppid;
	private String appid;
	private String appidLogo;
	private String cardColor;
	private Timestamp cardStartTime;
	private Timestamp cardEndTime;
	private String cardTitle;
	private String cardSubTitle;
	private String cardChinaName;
	private Integer cardStatus;
	private String appidName;
	private float cardProbability;
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
	@Column(name = "detele_time")
	public Timestamp getDeteleTime() {
		return deteleTime;
	}
	public void setDeteleTime(Timestamp deteleTime) {
		this.deteleTime = deteleTime;
	}
	@Column(name = "card_id")
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	@Column(name = "chose_appid")
	public String getChoseAppid() {
		return choseAppid;
	}
	public void setChoseAppid(String choseAppid) {
		this.choseAppid = choseAppid;
	}
	@Column(name = "appid")
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	@Column(name = "appid_logo")
	public String getAppidLogo() {
		return appidLogo;
	}
	public void setAppidLogo(String appidLogo) {
		this.appidLogo = appidLogo;
	}
	@Column(name = "card_color")
	public String getCardColor() {
		return cardColor;
	}
	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}
	@Column(name = "card_start_time")
	public Timestamp getCardStartTime() {
		return cardStartTime;
	}
	public void setCardStartTime(Timestamp cardStartTime) {
		this.cardStartTime = cardStartTime;
	}
	@Column(name = "card_end_time")
	public Timestamp getCardEndTime() {
		return cardEndTime;
	}
	public void setCardEndTime(Timestamp cardEndTime) {
		this.cardEndTime = cardEndTime;
	}
	@Column(name = "card_title")
	public String getCardTitle() {
		return cardTitle;
	}
	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}
	@Column(name = "card_sub_title")
	public String getCardSubTitle() {
		return cardSubTitle;
	}
	public void setCardSubTitle(String cardSubTitle) {
		this.cardSubTitle = cardSubTitle;
	}
	@Column(name = "card_china_name")
	public String getCardChinaName() {
		return cardChinaName;
	}
	public void setCardChinaName(String cardChinaName) {
		this.cardChinaName = cardChinaName;
	}
	@Column(name = "card_status")
	public Integer getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(Integer cardStatus) {
		this.cardStatus = cardStatus;
	}
	@Column(name = "appid_name")
	public String getAppidName() {
		return appidName;
	}
	public void setAppidName(String appidName) {
		this.appidName = appidName;
	}
	@Column(name = "card_probability")
	public float getCardProbability() {
		return cardProbability;
	}
	public void setCardProbability(float cardProbability) {
		this.cardProbability = cardProbability;
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

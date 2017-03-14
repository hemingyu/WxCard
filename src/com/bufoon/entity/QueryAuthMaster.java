package com.bufoon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="y_query_auth")
public class QueryAuthMaster {
	private Integer id;
	private String appid;
	private Integer userId;
	private String authorizerAccessToken;
	private Integer expiresIn;
	private String authorizerRefreshToken;
	private String funcInfo;
	private String funInfoContent;
	private Integer recordStatus;
	private Timestamp tokenStartTime;
	private Timestamp deleteTime;
	private Timestamp cardJsTicketStartTime;
	private String cardJsTicket;
	private String jsApiTicket;
	private Timestamp jsApiTicketStartTime;
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	 @GeneratedValue(generator = "generator")
	@Column(name = "ID", length=11)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "authorizer_appid")
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "authorizer_access_token")
	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}
	public void setAuthorizerAccessToken(String authorizerAccessToken) {
		this.authorizerAccessToken = authorizerAccessToken;
	}
	@Column(name = "expires_in")
	public Integer getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
	@Column(name = "authorizer_refresh_token")
	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}
	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}
	@Column(name = "func_info")
	public String getFuncInfo() {
		return funcInfo;
	}
	public void setFuncInfo(String funcInfo) {
		this.funcInfo = funcInfo;
	}
	@Column(name = "fun_info_content")
	public String getFunInfoContent() {
		return funInfoContent;
	}
	public void setFunInfoContent(String funInfoContent) {
		this.funInfoContent = funInfoContent;
	}
	@Column(name = "record_status")
	public Integer getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}
	@Column(name = "start_time")
	public Timestamp getTokenStartTime() {
		return tokenStartTime;
	}
	public void setTokenStartTime(Timestamp tokenStartTime) {
		this.tokenStartTime = tokenStartTime;
	}
	@Column(name = "delete_time")
	public Timestamp getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
	@Column(name = "js_api_ticket")
	public String getJsApiTicket() {
		return jsApiTicket;
	}
	public void setJsApiTicket(String jsApiTicket) {
		this.jsApiTicket = jsApiTicket;
	}
	@Column(name = "js_api_ticket_start_time")
	public Timestamp getJsApiTicketStartTime() {
		return jsApiTicketStartTime;
	}
	public void setJsApiTicketStartTime(Timestamp jsApiTicketStartTime) {
		this.jsApiTicketStartTime = jsApiTicketStartTime;
	}
	@Column(name = "card_ticket_start_time")
	public Timestamp getCardJsTicketStartTime() {
		return cardJsTicketStartTime;
	}
	public void setCardJsTicketStartTime(Timestamp cardJsTicketStartTime) {
		this.cardJsTicketStartTime = cardJsTicketStartTime;
	}
	@Column(name = "card_ticket")
	public String getCardJsTicket() {
		return cardJsTicket;
	}
	public void setCardJsTicket(String cardJsTicket) {
		this.cardJsTicket = cardJsTicket;
	}
	
}

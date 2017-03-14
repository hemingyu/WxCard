package com.bufoon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="y_component_accesstoken")
public class ComponentAccessToken {
	private Integer id;
	private String appid;
	/*平台AccessToken*/
	private String componentAccessToken;
	private Timestamp componentTokenStartTime;
	private Integer componentTokenExpiresIn;
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
	@Column(name = "appid")
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	@Column(name = "component_access_token")
	public String getComponentAccessToken() {
		return componentAccessToken;
	}
	public void setComponentAccessToken(String componentAccessToken) {
		this.componentAccessToken = componentAccessToken;
	}
	@Column(name = "component_token_start_time")
	public Timestamp getComponentTokenStartTime() {
		return componentTokenStartTime;
	}
	public void setComponentTokenStartTime(Timestamp componentTokenStartTime) {
		this.componentTokenStartTime = componentTokenStartTime;
	}
	@Column(name = "component_token_expires_in")
	public Integer getComponentTokenExpiresIn() {
		return componentTokenExpiresIn;
	}
	public void setComponentTokenExpiresIn(Integer componentTokenExpiresIn) {
		this.componentTokenExpiresIn = componentTokenExpiresIn;
	}
	
}

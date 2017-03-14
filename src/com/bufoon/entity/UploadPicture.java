package com.bufoon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="c_uploadpicture")
public class UploadPicture {
	private Integer bewinId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String openid;
	private String serverId;
	
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
	@Column(name = "server_id")
	public String getServerId() {
	    return serverId;
	}
	public void setServerId(String serverId) {
	    this.serverId = serverId;
	}
	
}

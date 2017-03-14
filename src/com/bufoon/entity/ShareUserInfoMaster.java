package com.bufoon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="c_shareuserinfo")
public class ShareUserInfoMaster {
	private Integer bewinId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String openid;
	private String shareopenid;
	private String sharecardid;
	private String sharecardtitle;
	private String nickname;
	private String sex;
	private String province;
	private String city;
	private String country;
	private String headimgurl;
	private String unionid;
	private String cardid;
	private String cardtitle;
	private String log1;
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
	@Column(name = "shareopenid")
	public String getShareOpenId() {
		return shareopenid;
	}
	public void setShareOpenId(String shareopenid) {
		this.shareopenid = shareopenid;
	}
	@Column(name = "sharecardid")
	public String getShareCardid() {
		return sharecardid;
	}
	public void setShareCardid(String sharecardid) {
		this.sharecardid = sharecardid;
	}
	@Column(name = "sharecardtitle")
	public String getShareCardtitle() {
		return sharecardtitle;
	}
	public void setShareCardtitle(String sharecardtitle) {
		this.sharecardtitle = sharecardtitle;
	}
	
	@Column(name = "nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Column(name = "sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name = "province")
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	@Column(name = "cardid")
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}	@Column(name = "cardtitle")
	public String getCardtitle() {
		return cardtitle;
	}
	public void setCardtitle(String cardtitle) {
		this.cardtitle = cardtitle;
	}
	
	@Column(name = "log1")
	public String getLog1() {
		return log1;
	}
	public void setLog1(String log1) {
		this.log1 = log1;
	}	
}

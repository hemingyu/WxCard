package com.bufoon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="y_active")
public class ActiveMaster {
	private Integer bewinId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String appid;
	private Timestamp activeStartTime;
	private Timestamp activeEndTime;
	private Integer lotteryNumber;
	private Integer totalProbability;
	private Integer redpackProbability;
	private Integer mustOneWinStatus;
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
	@Column(name = "update_time")
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "appid")
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	@Column(name = "active_start_time")
	public Timestamp getActiveStartTime() {
		return activeStartTime;
	}
	public void setActiveStartTime(Timestamp activeStartTime) {
		this.activeStartTime = activeStartTime;
	}
	@Column(name = "active_end_time")
	public Timestamp getActiveEndTime() {
		return activeEndTime;
	}
	public void setActiveEndTime(Timestamp activeEndTime) {
		this.activeEndTime = activeEndTime;
	}
	@Column(name = "lottery_number")
	public Integer getLotteryNumber() {
		return lotteryNumber;
	}
	public void setLotteryNumber(Integer lotteryNumber) {
		this.lotteryNumber = lotteryNumber;
	}
	@Column(name = "total_probability")
	public Integer getTotalProbability() {
		return totalProbability;
	}
	public void setTotalProbability(Integer totalProbability) {
		this.totalProbability = totalProbability;
	}
	@Column(name = "redpack_probability")
	public Integer getRedpackProbability() {
		return redpackProbability;
	}
	public void setRedpackProbability(Integer redpackProbability) {
		this.redpackProbability = redpackProbability;
	}
	@Column(name = "must_one_win_status")
	public Integer getMustOneWinStatus() {
		return mustOneWinStatus;
	}
	public void setMustOneWinStatus(Integer mustOneWinStatus) {
		this.mustOneWinStatus = mustOneWinStatus;
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

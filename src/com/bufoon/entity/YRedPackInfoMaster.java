package com.bufoon.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="y_redpackinfo")
public class YRedPackInfoMaster {
	private Integer bewinId;
	private Timestamp startTime;
	private Timestamp endTime;
	private String appid;
	private char redpackStatus;
	private String redpackName;
	private String redpackTotalMoney;
	private String redpackBalance;
	private String redpackMinMoney;
	private String redpackMaxMoney;
	private String redpackTitle;
	private String singleGetReapackNumber;
	private String prizeRate;
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
	@Column(name = "start_time")
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	@Column(name = "end_time")
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	@Column(name = "appid")
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	@Column(name = "redpack_status")
	public char getRedpackStatus() {
		return redpackStatus;
	}
	public void setRedpackStatus(char redpackStatus) {
		this.redpackStatus = redpackStatus;
	}
	@Column(name = "redpack_name")
	public String getRedpackName() {
		return redpackName;
	}
	public void setRedpackName(String redpackName) {
		this.redpackName = redpackName;
	}
	@Column(name = "redpack_balance")
	public String getRedpackBalance() {
		return redpackBalance;
	}
	public void setRedpackBalance(String redpackBalance) {
		this.redpackBalance = redpackBalance;
	}
	@Column(name = "redpack_total_money")
	public String getRedpackTotalMoney() {
		return redpackTotalMoney;
	}
	public void setRedpackTotalMoney(String redpackTotalMoney) {
		this.redpackTotalMoney = redpackTotalMoney;
	}
	@Column(name = "redpack_min_money")
	public String getRedpackMinMoney() {
		return redpackMinMoney;
	}
	public void setRedpackMinMoney(String redpackMinMoney) {
		this.redpackMinMoney = redpackMinMoney;
	}
	@Column(name = "redpack_max_money")
	public String getRedpackMaxMoney() {
		return redpackMaxMoney;
	}
	public void setRedpackMaxMoney(String redpackMaxMoney) {
		this.redpackMaxMoney = redpackMaxMoney;
	}
	@Column(name = "redpack_title")
	public String getRedpackTitle() {
		return redpackTitle;
	}
	public void setRedpackTitle(String redpackTitle) {
		this.redpackTitle = redpackTitle;
	}
	@Column(name = "single_get_reapack_number")
	public String getSingleGetReapackNumber() {
		return singleGetReapackNumber;
	}
	public void setSingleGetReapackNumber(String singleGetReapackNumber) {
		this.singleGetReapackNumber = singleGetReapackNumber;
	}
	@Column(name = "prize_rate")
	public String getPrizeRate() {
		return prizeRate;
	}
	public void setPrizeRate(String prizeRate) {
		this.prizeRate = prizeRate;
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

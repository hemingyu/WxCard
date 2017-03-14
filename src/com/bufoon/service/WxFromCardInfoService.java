package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.WxFromCardInfoMaster;

public interface WxFromCardInfoService {
	public boolean saveWxFromCardInfoMaster(WxFromCardInfoMaster user);
	
	public void updateWxFromCardInfoMaster(WxFromCardInfoMaster user);
	 
	public WxFromCardInfoMaster getWxFromCardInfoMaster(String sql);
	
	public void deleteWxFromCardInfoMaster(WxFromCardInfoMaster user);
	
	public List<WxFromCardInfoMaster> findAllList(String hql);
	
	public List<WxFromCardInfoMaster> find(String hql, Object[] param, Integer page, Integer rows);
	
	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, Object[] param);
	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @return
	 */
	public Long count(String hql);
}

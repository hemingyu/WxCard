package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.SubscribeInfoMaster;

public interface SubscribeInfoService {
	public boolean saveSubscribeInfoMaster(SubscribeInfoMaster user);
	
	public void updateSubscribeInfoMaster(SubscribeInfoMaster user);
	 
	public SubscribeInfoMaster getSubscribeInfoMaster(String sql);
	
	public void deleteSubscribeInfoMaster(SubscribeInfoMaster user);
	
	public List<SubscribeInfoMaster> findAllList(String hql);
	
	public List<SubscribeInfoMaster> find(String hql, Object[] param, Integer page, Integer rows);
	
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

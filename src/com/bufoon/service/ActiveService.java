package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.ActiveMaster;

public interface ActiveService {
	public boolean saveActiveMaster(ActiveMaster user);
	
	public void updateActiveMaster(ActiveMaster user);
	 
	public ActiveMaster getActiveMaster(String sql);
	
	public void deleteActiveMaster(ActiveMaster user);
	
	public List<ActiveMaster> findAllList(String hql);
	
	public List<ActiveMaster> find(String hql, Object[] param, Integer page, Integer rows);
	
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

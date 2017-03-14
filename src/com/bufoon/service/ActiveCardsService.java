package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.ActiveCardsMaster;

public interface ActiveCardsService {
	public boolean saveActiveCardsMaster(ActiveCardsMaster user);
	
	public void updateActiveCardsMaster(ActiveCardsMaster user);
	 
	public ActiveCardsMaster getActiveCardsMaster(String sql);
	
	public void deleteActiveCardsMaster(ActiveCardsMaster user);
	
	public List<ActiveCardsMaster> findAllList(String hql);
	
	public List<ActiveCardsMaster> find(String hql, Object[] param, Integer page, Integer rows);
	
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

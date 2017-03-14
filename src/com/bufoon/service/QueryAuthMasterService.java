package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.QueryAuthMaster;

public interface QueryAuthMasterService {
	public boolean saveQueryAuthMaster(QueryAuthMaster aueryAuthMaster);

	public void updateQueryAuthMaster(QueryAuthMaster aueryAuthMaster);

	public QueryAuthMaster getQueryAuthMaster(String sql);

	public void deleteQueryAuthMaster(QueryAuthMaster aueryAuthMaster);

	public List<QueryAuthMaster> findAllList(String hql);

	public List<QueryAuthMaster> find(String hql, Object[] param, Integer page, Integer rows);

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

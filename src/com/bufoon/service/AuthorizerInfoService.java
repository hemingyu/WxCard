package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.AuthorizerInfoMaster;

public interface AuthorizerInfoService {
	public boolean saveAuthorizerInfoMaster(AuthorizerInfoMaster authorizerInfoMatser);

	public void updateAuthorizerInfoMaster(AuthorizerInfoMaster authorizerInfoMatser);

	public AuthorizerInfoMaster getAuthorizerInfoMatser(String sql);

	public void deleteAuthorizerInfoMaster(AuthorizerInfoMaster authorizerInfoMatser);

	public List<AuthorizerInfoMaster> findAllList();

	public List<AuthorizerInfoMaster> find(String hql, Object[] param, Integer page, Integer rows);

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

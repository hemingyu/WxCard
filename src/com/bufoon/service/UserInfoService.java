package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.UserInfoMaster;

public interface UserInfoService {
	public boolean saveUserInfoMaster(UserInfoMaster user);
	
	public void updateUserInfoMaster(UserInfoMaster user);
	 
	public UserInfoMaster getUserInfoMaster(String sql);
	
	public void deleteUserInfoMaster(UserInfoMaster user);
	
	public List<UserInfoMaster> findAllList(String hql);
	
	public List<UserInfoMaster> find(String hql, Object[] param, Integer page, Integer rows);
	
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

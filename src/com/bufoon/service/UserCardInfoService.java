package com.bufoon.service;

import java.util.List;
import com.bufoon.entity.UserCardInfo;

public interface UserCardInfoService {
	public boolean saveUserCardInfo(UserCardInfo user);
	
	public void updateUserCardInfo(UserCardInfo user);
	 
	public UserCardInfo getUserCardInfo(String sql);
	
	public List<UserCardInfo> find(String hql, Object[] param, Integer page,
		Integer rows);
	
	public List<UserCardInfo> findAllList(String hql);
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

package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.ShareUserInfoMaster;

public interface ShareUserInfoService {
	public boolean saveShareUserInfoMaster(ShareUserInfoMaster user);
	
	public void updateShareUserInfoMaster(ShareUserInfoMaster user);
	 
	public ShareUserInfoMaster getShareUserInfoMaster(String sql);
	
	public void deleteShareUserInfoMaster(ShareUserInfoMaster user);
	
	public List<ShareUserInfoMaster> findAllList(String sql);
	
	public List<ShareUserInfoMaster> find(String hql, Object[] param, Integer page, Integer rows);
	
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

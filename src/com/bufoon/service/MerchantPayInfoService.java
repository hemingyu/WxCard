package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.MerchantPayInfoMaster;

public interface MerchantPayInfoService {
	public boolean saveMerchantPayInfoMaster(MerchantPayInfoMaster user);
	
	public void updateMerchantPayInfoMaster(MerchantPayInfoMaster user);
	 
	public MerchantPayInfoMaster getMerchantPayInfoMaster(String sql);
	
	public void deleteMerchantPayInfoMaster(MerchantPayInfoMaster user);
	
	public List<MerchantPayInfoMaster> findAllList(String hql);
	
	public List<MerchantPayInfoMaster> find(String hql, Object[] param, Integer page, Integer rows);
	
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

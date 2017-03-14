package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.StoresInfo;

public interface StoresService {
	public boolean saveStoresInfo(StoresInfo user);

	public void updateStoresInfo(StoresInfo user);

	public StoresInfo getStoresInfo(String sql);

	public void deleteStoresInfo(StoresInfo user);

	public List<StoresInfo> findAllList(String hql);

	public List<StoresInfo> find(String hql, Object[] param, Integer page, Integer rows);

}

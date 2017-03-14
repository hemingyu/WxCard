package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.model.UseValue;
import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.StoresInfo;
import com.bufoon.service.StoresService;

@Service("storesService")
public class StoresServiceImpl implements StoresService{
	@Resource
	
	private BaseDAO<StoresInfo> baseDAO;
	@Override
	public boolean saveStoresInfo(StoresInfo storesInfo) {
			try{
				baseDAO.saveOrUpdate(storesInfo);
			}catch(Exception e){
		}
		return false;
	}

	@Override
	public void updateStoresInfo(StoresInfo storesInfo) {
		baseDAO.saveOrUpdate(storesInfo);
	}

	@Override
	public StoresInfo getStoresInfo(String sql) {
		return baseDAO.executeSql(sql, StoresInfo.class);
	}

	@Override
	public void deleteStoresInfo(StoresInfo storesInfo) {
		baseDAO.delete(storesInfo);
		
	}

	@Override
	public List<StoresInfo> findAllList(String hql) {
		return baseDAO.find(hql);
	}

	@Override
	public List<StoresInfo> find(String hql, Object[] param, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

}

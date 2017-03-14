package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.SubscribeInfoMaster;
import com.bufoon.service.SubscribeInfoService;

@Service("subscribeInfoService")
public class SubscribeInfoServiceImpl implements SubscribeInfoService{

	@Resource
	private BaseDAO<SubscribeInfoMaster> baseDAO;
	
	@Override
	public boolean saveSubscribeInfoMaster(SubscribeInfoMaster subscribeInfoMaster) {
		try{
			baseDAO.save(subscribeInfoMaster);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateSubscribeInfoMaster(SubscribeInfoMaster subscribeInfoMaster) {
		baseDAO.saveOrUpdate(subscribeInfoMaster);
	}

	@Override
	public void deleteSubscribeInfoMaster(SubscribeInfoMaster subscribeInfoMaster) {
		baseDAO.delete(subscribeInfoMaster);
		
	}

	@Override
	public List<SubscribeInfoMaster> findAllList(String hql) {
		return baseDAO.find(hql);
	}

	@Override
	public List<SubscribeInfoMaster> find(String hql, Object[] param, Integer page,
			Integer rows) {
		
		return baseDAO.find(hql, param, page, rows);
	}

	@Override
	public Long count(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubscribeInfoMaster getSubscribeInfoMaster(String sql) {
		return baseDAO.executeSql(sql, SubscribeInfoMaster.class);
	}


}

package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.ActiveCardsMaster;
import com.bufoon.service.ActiveCardsService;

@Service("activeCardsService")
public class ActiveCardsServiceImpl implements ActiveCardsService{

	@Resource
	private BaseDAO<ActiveCardsMaster> baseDAO;
	
	@Override
	public boolean saveActiveCardsMaster(ActiveCardsMaster activeCardsMaster) {
		try{
			baseDAO.save(activeCardsMaster);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateActiveCardsMaster(ActiveCardsMaster activeCardsMaster) {
		baseDAO.saveOrUpdate(activeCardsMaster);
	}

	@Override
	public void deleteActiveCardsMaster(ActiveCardsMaster activeCardsMaster) {
		baseDAO.delete(activeCardsMaster);
		
	}

	@Override
	public List<ActiveCardsMaster> findAllList(String hql) {
		return baseDAO.find(hql);
	}

	@Override
	public List<ActiveCardsMaster> find(String hql, Object[] param, Integer page,
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
	public ActiveCardsMaster getActiveCardsMaster(String sql) {
		return baseDAO.executeSql(sql, ActiveCardsMaster.class);
	}


}

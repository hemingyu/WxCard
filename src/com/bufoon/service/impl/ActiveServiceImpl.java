package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.ActiveMaster;
import com.bufoon.service.ActiveService;

@Service("activeService")
public class ActiveServiceImpl implements ActiveService{

	@Resource
	private BaseDAO<ActiveMaster> baseDAO;
	
	@Override
	public boolean saveActiveMaster(ActiveMaster activeMaster) {
		try{
			baseDAO.save(activeMaster);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateActiveMaster(ActiveMaster activeMaster) {
		baseDAO.saveOrUpdate(activeMaster);
	}

	@Override
	public void deleteActiveMaster(ActiveMaster activeMaster) {
		baseDAO.delete(activeMaster);
		
	}

	@Override
	public List<ActiveMaster> findAllList(String hql) {
		return baseDAO.find(hql);
	}

	@Override
	public List<ActiveMaster> find(String hql, Object[] param, Integer page,
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
	public ActiveMaster getActiveMaster(String sql) {
		return baseDAO.executeSql(sql, ActiveMaster.class);
	}


}

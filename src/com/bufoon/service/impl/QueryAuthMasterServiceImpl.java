package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.QueryAuthMaster;
import com.bufoon.service.QueryAuthMasterService;


@Service("queryAuthMasterService")
public class QueryAuthMasterServiceImpl implements QueryAuthMasterService{
	@Resource
	private BaseDAO<QueryAuthMaster> baseDAO; 
	
	@Override
	public boolean saveQueryAuthMaster(QueryAuthMaster aueryAuthMaster) {
		baseDAO.save(aueryAuthMaster);
		return true;
	}

	@Override
	public void updateQueryAuthMaster(QueryAuthMaster aueryAuthMaster) {
		baseDAO.update(aueryAuthMaster);
	}

	@Override
	public QueryAuthMaster getQueryAuthMaster(String sql) {
		return baseDAO.executeSql(sql, QueryAuthMaster.class);
	}

	@Override
	public void deleteQueryAuthMaster(QueryAuthMaster aueryAuthMaster) {
		baseDAO.delete(aueryAuthMaster);
	}

	@Override
	public List<QueryAuthMaster> findAllList(String hql) {
		return baseDAO.find(hql);
	}
	@Override
	public List<QueryAuthMaster> find(String hql, Object[] param, Integer page, Integer rows) {
		return null;
	}

	@Override
	public Long count(String hql, Object[] param) {
		return null;
	}

	@Override
	public Long count(String hql) {
		return null;
	}

}

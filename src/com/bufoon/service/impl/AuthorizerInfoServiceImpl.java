package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.AuthorizerInfoMaster;
import com.bufoon.service.AuthorizerInfoService;

@Service("authorizerInfoService")
public class AuthorizerInfoServiceImpl implements AuthorizerInfoService {
	@Resource
	private BaseDAO<AuthorizerInfoMaster> baseDAO;

	@Override
	public boolean saveAuthorizerInfoMaster(AuthorizerInfoMaster authorizerInfoMatser) {
		baseDAO.save(authorizerInfoMatser);
		return true;
	}

	@Override
	public void updateAuthorizerInfoMaster(AuthorizerInfoMaster authorizerInfoMatser) {
		baseDAO.update(authorizerInfoMatser);
		
	}

	@Override
	public AuthorizerInfoMaster getAuthorizerInfoMatser(String sql) {
		return baseDAO.executeSql(sql, AuthorizerInfoMaster.class);
	}

	@Override
	public void deleteAuthorizerInfoMaster(AuthorizerInfoMaster authorizerInfoMatser) {
		baseDAO.delete(authorizerInfoMatser);
	}

	@Override
	public List<AuthorizerInfoMaster> findAllList() {
		String  hql ="from AuthorizerInfoMaster where recordStatus =1";
		return baseDAO.find(hql);
	}

	@Override
	public List<AuthorizerInfoMaster> find(String hql, Object[] param, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		return null;
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



}

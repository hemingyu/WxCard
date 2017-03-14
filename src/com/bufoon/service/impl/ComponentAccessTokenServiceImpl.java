package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.ComponentAccessToken;
import com.bufoon.service.ComponentAccessTokenService;

@Service("componentAccessTokenService")
public class ComponentAccessTokenServiceImpl implements ComponentAccessTokenService {
	@Resource
	private BaseDAO<ComponentAccessToken> baseDAO;

	@Override
	public boolean saveComponentAccessToken(ComponentAccessToken componentAccessToken) {
		baseDAO.save(componentAccessToken);
		return true;
	}

	@Override
	public void updateComponentAccessToken(ComponentAccessToken componentAccessToken) {
		baseDAO.update(componentAccessToken);
	}

	@Override
	public ComponentAccessToken getComponentAccessToken(String sql) {
		return baseDAO.executeSql(sql, ComponentAccessToken.class);
	}

	@Override
	public void deleteComponentAccessToken(ComponentAccessToken componentAccessToken) {
		baseDAO.delete(componentAccessToken);
	}

	@Override
	public List<ComponentAccessToken> findAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComponentAccessToken> find(String hql, Object[] param, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

}

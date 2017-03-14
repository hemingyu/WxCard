package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.ComponentAccessToken;

public interface ComponentAccessTokenService {
	public boolean saveComponentAccessToken(ComponentAccessToken user);

	public void updateComponentAccessToken(ComponentAccessToken user);

	public ComponentAccessToken getComponentAccessToken(String sql);

	public void deleteComponentAccessToken(ComponentAccessToken user);

	public List<ComponentAccessToken> findAllList();

	public List<ComponentAccessToken> find(String hql, Object[] param, Integer page, Integer rows);
}

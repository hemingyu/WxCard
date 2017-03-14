package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.Login;

public interface LoginService {

	public void saveLogin(Login user);
	
	public void updateLogin(Login user);
	
/*	public Login loginIn(String username,String password);*/
	
	public void deleteLogin(Login user);
	
	public List<Login> findAllList(String hql);
	
	public Login getLogin(String sql);
	
	/**
	 * 查询所有有效授权方的信息
	 * @param sql
	 * @return
	 */
	public List<Login> findOAuthList(String sql);
}

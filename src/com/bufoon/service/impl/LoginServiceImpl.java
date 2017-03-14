package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.Login;
import com.bufoon.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private BaseDAO<Login> baseDAO;

	@Override
	public void deleteLogin(Login login) {
		
	}

	@Override
	public List<Login> findAllList(String hql) {
		
		return baseDAO.find(hql);
	}


	@Override
	public void saveLogin(Login login) {
		baseDAO.save(login);
		
	}

	@Override
	public void updateLogin(Login login) {
			baseDAO.update(login);
	}

/*	@Override
	public Login loginIn(String username, String password) {
		String sql="select * from t_login u where u.username='"+username+"' and u.password='"+password+"'";
		return baseDAO.executeSql(sql, Login.class);
	}*/

	@Override
	public Login getLogin(String sql) {
		return baseDAO.executeSql(sql, Login.class);
	}

	@Override
	public List<Login> findOAuthList(String sql) {
		return baseDAO.executeSqlList(sql, Login.class);
	}


}

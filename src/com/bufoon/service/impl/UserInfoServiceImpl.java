package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.model.UseValue;
import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.UserInfoMaster;
import com.bufoon.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{

	@Resource
	private BaseDAO<UserInfoMaster> baseDAO;
	
	@Override
	public boolean saveUserInfoMaster(UserInfoMaster userInfoMaster) {
		try{
			baseDAO.save(userInfoMaster);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateUserInfoMaster(UserInfoMaster userInfoMaster) {
		baseDAO.saveOrUpdate(userInfoMaster);
	}

	@Override
	public void deleteUserInfoMaster(UserInfoMaster userInfoMaster) {
		baseDAO.delete(userInfoMaster);
		
	}

	@Override
	public List<UserInfoMaster> findAllList(String hql) {
		return baseDAO.find(hql);
	}

	@Override
	public List<UserInfoMaster> find(String hql, Object[] param, Integer page,
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
		Long num = baseDAO.count(hql);
		return num;
	}

	@Override
	public UserInfoMaster getUserInfoMaster(String sql) {
		return baseDAO.executeSql(sql, UserInfoMaster.class);
	}


}

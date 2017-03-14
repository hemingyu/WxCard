package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.UserCardInfo;
import com.bufoon.service.UserCardInfoService;
@Service("userCardInfoService")
public class UserCardInfoServiceImpl implements UserCardInfoService {
    
    @Resource
    private BaseDAO<UserCardInfo> baseDAO;
    
    @Override
    public boolean saveUserCardInfo(UserCardInfo user) {
	// TODO Auto-generated method stub
	try{
		baseDAO.save(user);
		return true;
	}catch(Exception e){
		e.printStackTrace();
	}
	return false;
    }

    @Override
    public void updateUserCardInfo(UserCardInfo user) {
	// TODO Auto-generated method stub
	baseDAO.saveOrUpdate(user);
    }

    @Override
    public UserCardInfo getUserCardInfo(String sql) {
	// TODO Auto-generated method stub
	return baseDAO.executeSql(sql, UserCardInfo.class);
    }
    @Override
    public Long count(String hql) {
        // TODO Auto-generated method stub
	Long num = baseDAO.count(hql);
	return num;
    }
    
    @Override
    public Long count(String hql, Object[] param) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<UserCardInfo> findAllList(String hql) {
        // TODO Auto-generated method stub
	return baseDAO.find(hql);
    }
    
    @Override
    public List<UserCardInfo> find(String hql, Object[] param, Integer page,
            Integer rows) {
        // TODO Auto-generated method stub
	return baseDAO.find(hql, param, page, rows);
    }
}

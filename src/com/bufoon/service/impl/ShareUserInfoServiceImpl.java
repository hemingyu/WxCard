package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.model.UseValue;
import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.ShareUserInfoMaster;
import com.bufoon.service.ShareUserInfoService;

@Service("shareuserInfoService")
public class ShareUserInfoServiceImpl implements ShareUserInfoService{

	@Resource
	private BaseDAO<ShareUserInfoMaster> baseDAO;
	
	@Override
	public boolean saveShareUserInfoMaster(ShareUserInfoMaster shareuserInfoMaster) {
		try{
			baseDAO.save(shareuserInfoMaster);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateShareUserInfoMaster(ShareUserInfoMaster shareuserInfoMaster) {
		baseDAO.saveOrUpdate(shareuserInfoMaster);
	}

	@Override
	public void deleteShareUserInfoMaster(ShareUserInfoMaster shareuserInfoMaster) {
		baseDAO.delete(shareuserInfoMaster);
		
	}

	@Override
	public List<ShareUserInfoMaster> findAllList(String sql) {
		return baseDAO.executeSqlList(sql, ShareUserInfoMaster.class);
	}

	@Override
	public List<ShareUserInfoMaster> find(String hql, Object[] param, Integer page,
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
	public ShareUserInfoMaster getShareUserInfoMaster(String sql) {
		return baseDAO.executeSql(sql, ShareUserInfoMaster.class);
	}


}

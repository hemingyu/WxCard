package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.MerchantPayInfoMaster;
import com.bufoon.service.MerchantPayInfoService;

@Service("merchantPayInfoService")
public class MerchantPayInfoServiceImpl implements MerchantPayInfoService{

	@Resource
	private BaseDAO<MerchantPayInfoMaster> baseDAO;
	
	@Override
	public boolean saveMerchantPayInfoMaster(MerchantPayInfoMaster activeMaster) {
		try{
			baseDAO.save(activeMaster);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateMerchantPayInfoMaster(MerchantPayInfoMaster activeMaster) {
		baseDAO.saveOrUpdate(activeMaster);
	}

	@Override
	public void deleteMerchantPayInfoMaster(MerchantPayInfoMaster activeMaster) {
		baseDAO.delete(activeMaster);
		
	}

	@Override
	public List<MerchantPayInfoMaster> findAllList(String hql) {
		return baseDAO.find(hql);
	}

	@Override
	public List<MerchantPayInfoMaster> find(String hql, Object[] param, Integer page,
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
	public MerchantPayInfoMaster getMerchantPayInfoMaster(String sql) {
		return baseDAO.executeSql(sql, MerchantPayInfoMaster.class);
	}


}

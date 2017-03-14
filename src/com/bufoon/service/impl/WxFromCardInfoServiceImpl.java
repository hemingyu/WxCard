package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.WxFromCardInfoMaster;
import com.bufoon.service.WxFromCardInfoService;

@Service("wxFromCardInfoService")
public class WxFromCardInfoServiceImpl implements WxFromCardInfoService{

	@Resource
	private BaseDAO<WxFromCardInfoMaster> baseDAO;
	
	@Override
	public boolean saveWxFromCardInfoMaster(WxFromCardInfoMaster wxFromCardInfoMaster) {
		try{
			baseDAO.save(wxFromCardInfoMaster);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateWxFromCardInfoMaster(WxFromCardInfoMaster wxFromCardInfoMaster) {
		baseDAO.saveOrUpdate(wxFromCardInfoMaster);
	}

	@Override
	public void deleteWxFromCardInfoMaster(WxFromCardInfoMaster wxFromCardInfoMaster) {
		baseDAO.delete(wxFromCardInfoMaster);
		
	}

	@Override
	public List<WxFromCardInfoMaster> findAllList(String hql) {
		return baseDAO.find(hql);
	}

	@Override
	public List<WxFromCardInfoMaster> find(String hql, Object[] param, Integer page,
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
	public WxFromCardInfoMaster getWxFromCardInfoMaster(String sql) {
		return baseDAO.executeSql(sql, WxFromCardInfoMaster.class);
	}


}

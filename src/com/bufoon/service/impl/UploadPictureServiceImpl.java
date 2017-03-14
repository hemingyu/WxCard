package com.bufoon.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.UploadPicture;
import com.bufoon.service.UploadPictureService;
@Service("uploadPictureService")
public class UploadPictureServiceImpl implements UploadPictureService {
    @Resource
    private BaseDAO<UploadPicture> baseDAO;
    @Override
    public UploadPicture getUploadPicture(String sql) {
        // TODO Auto-generated method stub
	return baseDAO.executeSql(sql, UploadPicture.class);
    }
    @Override
    public boolean saveUploadPicture(UploadPicture user) {
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
    public void updateUploadPicture(UploadPicture user) {
	// TODO Auto-generated method stub
	baseDAO.saveOrUpdate(user);
    }
}

package com.bufoon.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.YRedPackInfoMaster;
import com.bufoon.service.YRedPackInfoService;

@Service("yRedPackInfoService")
public class YRedPackInfoServiceImpl  implements YRedPackInfoService{
	@Resource
	private BaseDAO<YRedPackInfoMaster> baseDAO;
	@Override
	public void saveYRedPackInfoMaster(YRedPackInfoMaster redPackInfo) {
		baseDAO.save(redPackInfo);
	}

	@Override
	public void updateYRedPackInfoMaster(YRedPackInfoMaster redPackInfo) {
		baseDAO.update(redPackInfo);
	}

	@Override
	public YRedPackInfoMaster getYRedPackInfoMaster(String sql) {
		return baseDAO.executeSql(sql, YRedPackInfoMaster.class);
	}

}

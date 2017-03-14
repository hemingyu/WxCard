package com.bufoon.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.RedPackInfo;
import com.bufoon.service.RedPackInfoService;

@Service("redPackInfoService")
public class RedPackInfoServiceImpl  implements RedPackInfoService{
	@Resource
	private BaseDAO<RedPackInfo> baseDAO;
	@Override
	public void saveRedPackInfo(RedPackInfo redPackInfo) {
		baseDAO.save(redPackInfo);
	}

	@Override
	public void updateRedPackInfo(RedPackInfo redPackInfo) {
		baseDAO.update(redPackInfo);
	}

	@Override
	public RedPackInfo getRedPackInfo(String sql) {
		return baseDAO.executeSql(sql, RedPackInfo.class);
	}

}

package com.bufoon.service;

import com.bufoon.entity.YRedPackInfoMaster;;

public interface YRedPackInfoService {
	public void saveYRedPackInfoMaster(YRedPackInfoMaster yRedPackInfoMaster);

	public void updateYRedPackInfoMaster(YRedPackInfoMaster yRedPackInfoMaster);

	public YRedPackInfoMaster getYRedPackInfoMaster(String sql);
}

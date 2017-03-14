package com.bufoon.service;

import com.bufoon.entity.RedPackInfo;

public interface RedPackInfoService {
	public void saveRedPackInfo(RedPackInfo redPackInfo);

	public void updateRedPackInfo(RedPackInfo redPackInfo);

	public RedPackInfo getRedPackInfo(String sql);
}

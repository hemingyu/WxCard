package com.bufoon.service;


import com.bufoon.entity.UploadPicture;


public interface UploadPictureService {
	public boolean saveUploadPicture(UploadPicture user);
	
	public void updateUploadPicture(UploadPicture user);
	 
	public UploadPicture getUploadPicture(String sql);
	
}

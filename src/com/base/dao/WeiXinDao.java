package com.base.dao;

import com.base.model.AccessToken;

public interface WeiXinDao {
//	/**
//	 * 文本内消息处�?
//	 * */
//	public String doTextNew(TextEntity textEntity);
//	
//	/**
//	 * 订阅处理
//	 * @throws Exception 
//	 * */
//	public String doSubscribe(EventEntity eventEntity);
//
//	/** 
//	 * 菜单点击处理
//	 * @throws Exception 
//	 * */
//	public String doMenuClick(MenuEntity menuEntity);
//	/**
//	 * 创建菜单
//	 */
//	public String createMenu(String params) throws Exception ;
//
//	/**
//	 * 查询菜单
//	 */
//	public String selectMenu() throws Exception;
//	
//	/**
//	 * 删除自定义菜�?
//	 */
//	public String deleteMenu() throws Exception ;
	/**
	 * 获取accessToken
	 */
	public AccessToken getAccessToken(String appid, String secret) throws Exception;
}

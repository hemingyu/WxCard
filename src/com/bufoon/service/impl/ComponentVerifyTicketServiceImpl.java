package com.bufoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.ComponentVerifyTicket;
import com.bufoon.service.ComponentVerifyTicketService;

@Service("componentVerifyTicketService")
public class ComponentVerifyTicketServiceImpl implements ComponentVerifyTicketService{

	@Resource
	private BaseDAO<ComponentVerifyTicket> baseDAO;
	@Override
	public boolean saveComponentVerifyTicket(ComponentVerifyTicket componentVerifyTicket) {
		baseDAO.save(componentVerifyTicket);
		return true;
	}

	@Override
	public void updateComponentVerifyTicket(ComponentVerifyTicket componentVerifyTicket) {
		baseDAO.update(componentVerifyTicket);
	}

	@Override
	public ComponentVerifyTicket getComponentVerifyTicket(String sql) {
		// TODO Auto-generated method stub
		return baseDAO.executeSql(sql, ComponentVerifyTicket.class);
	}

	@Override
	public void deleteComponentVerifyTicket(ComponentVerifyTicket componentVerifyTicket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ComponentVerifyTicket> findAllList() {
		String hql ="fromComponentVerifyTicket where 1= 1 ";
		return baseDAO.find(hql);
	}

	@Override
	public List<ComponentVerifyTicket> find(String hql, Object[] param, Integer page, Integer rows) {
		
		return null;
	}

}

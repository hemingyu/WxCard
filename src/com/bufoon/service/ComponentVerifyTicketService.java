package com.bufoon.service;

import java.util.List;

import com.bufoon.entity.ComponentVerifyTicket;

public interface ComponentVerifyTicketService {
	public boolean saveComponentVerifyTicket(ComponentVerifyTicket user);

	public void updateComponentVerifyTicket(ComponentVerifyTicket user);

	public ComponentVerifyTicket getComponentVerifyTicket(String sql);

	public void deleteComponentVerifyTicket(ComponentVerifyTicket user);

	public List<ComponentVerifyTicket> findAllList();

	public List<ComponentVerifyTicket> find(String hql, Object[] param, Integer page, Integer rows);
}

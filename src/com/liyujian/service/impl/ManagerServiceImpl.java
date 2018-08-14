package com.liyujian.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liyujian.dao.ManagerDao;
import com.liyujian.po.Manager;
import com.liyujian.service.ManagerService;
@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	@Resource
	private ManagerDao managerDao; 
	/* 登陆验证 */
	public Manager checkLogin(String manager_name, String manager_password) {
		//根据用户名实例化用户对象
		Manager manager = managerDao.findManagerByName(manager_name);
		if(manager!=null && manager.getManager_password().equals(manager_password)){
			return manager;
		}
		return null;
	}
	
}

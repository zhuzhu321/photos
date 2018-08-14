package com.liyujian.service;

import com.liyujian.po.Manager;

public interface ManagerService {
	// 通过用户名及密码核查用户登录
	public Manager checkLogin(String manager_name,String manager_password);
}

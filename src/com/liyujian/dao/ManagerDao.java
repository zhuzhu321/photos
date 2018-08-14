package com.liyujian.dao;

import com.liyujian.po.Manager;

public interface ManagerDao {
	public Manager findManagerByName(String manager_name);
}

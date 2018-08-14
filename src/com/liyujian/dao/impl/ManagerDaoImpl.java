package com.liyujian.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.liyujian.dao.ManagerDao;
import com.liyujian.mapper.ManagerMapper;
import com.liyujian.po.Manager;
@Repository("managerDao")//@Repository(value=”managerDao”)注解是告诉Spring，让Spring创建一个名字叫“managerDao”的ManagerDaoImpl实例。

                         //当Service需要使用Spring创建的名为“managerDao”的ManagerDaoImpl实例时， 
						 //就可以使用@Resource(name =”managerDao”)注解告诉Spring，Spring把创建好的managerDao注入给Service即可
public class ManagerDaoImpl implements ManagerDao{
	//注解引用Mapper类资源
	@Resource(name = "managerMapper")
    private ManagerMapper managerMapper;
	
	@Override
	 /* 根据用户名查找用户对象 */
	public Manager findManagerByName(String manager_name) {
		//调用Mapper类从数据库中得到Manager对象
		return managerMapper.getManagerByName(manager_name);
	}
		
}


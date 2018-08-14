package com.liyujian.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.liyujian.dao.ItemsDao;
import com.liyujian.mapper.ItemsMapper;
import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;

@Repository("itemsDao")
public class ItemsDaoImpl implements ItemsDao{
	//注解引用Mapper类资源
		@Resource(name = "itemsMapper")
	    private ItemsMapper itemsMapper;
	//查询所有分类，即所有items
	@Override
	public List<Items> findItems() throws Exception{
		return (List<Items>) itemsMapper.getAllItems();
	}
	
	//查询父分类所有子分类
	@Override
	public List<Company> findItemsChilderen(String item_id) throws Exception{
		return (List<Company>)itemsMapper.getItemsChildren(item_id);
	}

	@Override
	public List<Image> findImageById(String company_id)throws Exception{
		
		return itemsMapper.getImage(company_id);
	}

}

package com.liyujian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liyujian.dao.ItemsDao;
import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;
import com.liyujian.service.ItemsService;
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService{
	@Resource
	private ItemsDao itemsDao;
	@Override
	//查询所有分类
	public List<Items> findItems() throws Exception {
		List<Items> items = itemsDao.findItems();
		if(items!=null) {
			return items;
		}
		return null;
	}
	//查询所有子分类
	@Override
	public List<Company> findItemsChilderen(String item_id) throws Exception {
		List<Company> company =  itemsDao.findItemsChilderen(item_id);
		if(company!=null) {
			return company;
		}
		return null;
	}
	@Override
	public List<Image> findImageById(String company_id) throws Exception {
		List<Image> image = itemsDao.findImageById(company_id);
		if(image!=null) {
			return image;
		}
		return null;
	}

}

package com.liyujian.dao;

import java.util.List;

import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;

public interface ItemsDao {
	public List<Items> findItems() throws Exception;
	public List<Company> findItemsChilderen(String item_id) throws Exception;
	public List<Image> findImageById(String company_id) throws Exception;
	
}

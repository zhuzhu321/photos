package com.liyujian.mapper;

import java.util.List;

import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;

public interface ItemsMapper {
	//得到所有项目信息
	public List<Items> getAllItems();
	//得到所有子项目信息
	public List<Company> getItemsChildren(String item_id);
	//得到所有图片信息
	public List<Image> getImage(String company_id);
	
}

package com.liyujian.mapper;

import java.util.List;

import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;

public interface BackStageMapper {
	//插入新的分类
	public int addItem(String item_id,String item_name);
	//插入二级分类
	public int addCompany(String company_id,String company_name,String company_state,
			String item_img,String item_id);
	//查询一级分类
	public List<Items> getItems(String item_id);
	//查询一个二级分类
	public List<Company> getOneCompany(String company_id);
	//查询所有二级分类
	public List<Company> getAllCompany();
	//根据company_id查询所有图片
	public List<Image> getAllImageById(String company_id);
	public Image getImageById(String image_id);
	public int updateItem(Items items);
	public String getCompanyImgUrl(String company_id);
	public String getImageUrl(String image_id);
	public int updateCompany(Company company);
	public int addImage(Image image);
	public int updateImage(Image image);
	
	//删除1级分类
	public int deleteItems(String item_id);
	public String[] getAllCompanyId(String item_id);
	public String[] getAllImageId(String company_id);
	//删除2级分类
	public int deleteCompany(String[] companyIdArr);
	//删除图片
	public int deleteImage(String[] imageIdArr);
}

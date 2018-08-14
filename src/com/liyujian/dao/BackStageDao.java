package com.liyujian.dao;

import java.util.List;

import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;

public interface BackStageDao {
	public int addItem(String item_id,String item_name) throws Exception;
	public int addCompany(String company_id,String company_name,String company_state,
			String item_img,String item_id) throws Exception;
	public List<Items> findItems(String item_id) throws Exception;
	public List<Company> findOneCompany(String company_id) throws Exception;
	public List<Company> findAllCompany() throws Exception;
	public List<Image> finAllImageById(String company_id) throws Exception;
	public Image findImageById(String image_id) throws Exception;
	public int updateItem(Items items) throws Exception;
	public String findCompanyImgUrl(String company_id) throws Exception;
	public String findImageUrl(String image_id) throws Exception;
	public int updateCompany(Company company) throws Exception;
	public int addImage(Image image)  throws Exception;
	public int updateImage(Image image) throws Exception;
	public int deleteItems(String item_id) throws Exception;
	public int deleteCompany(String[] companyIdArr) throws Exception;
	public int deleteImage(String[] imageIdArr) throws Exception;
	public String[] findAllCompanyId(String item_id) throws Exception;
	public String[] findAllImageId(String company_id) throws Exception;
}

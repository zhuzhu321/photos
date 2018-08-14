package com.liyujian.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;

public interface BackStageService {
	public int addItem(String item_id, String item_name) throws Exception;
	public int addCompany(String company_id,String company_name,String company_state,
			String item_img,String item_id) throws Exception;
	public List<Items> findItems(String item_id)throws Exception;
	public List<Company> findOneCompany(String company_id)throws Exception;
	public List<Company> finAllCompany()throws Exception;
	public List<Image> findAllImageById(String company_id)throws Exception;
	public Image findImageById(String image_id)throws Exception;
	public int updateItem(Items items)throws Exception;
	public void removeCompanyImgById(String company_id,HttpServletRequest request)throws Exception;
	public void removeCompanyImgById(String[] companyIdArr,HttpServletRequest request)throws Exception;
	public void removeImageUrlById(String image_id,HttpServletRequest request)throws Exception;
	public void removeImageUrlById(String[]imageIdArr, HttpServletRequest request)throws Exception;
	public int updateCompany(Company company)throws Exception;
	public int addImage(Image image)throws Exception;
	public int updateImage(Image image)throws Exception;
	public void removeItemsById(String item_id)throws Exception;
	public void removeCompanyById(String[] companyIdArr)throws Exception;
	public void removeImageById(String[] imageIdArr)throws Exception;
	public String[] findAllCompanyId(String item_id)throws Exception;
	public String[] findAllImageId(String company_id)throws Exception;
}

package com.liyujian.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.liyujian.dao.BackStageDao;
import com.liyujian.mapper.BackStageMapper;
import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;
@Repository("backStageDao")
public class BackStageDaoImpl implements BackStageDao{
	@Resource(name="backStageMapper")
	private BackStageMapper backStageMapper;
	@Override
	public int addItem(String item_id, String item_name)throws Exception{
		int message = backStageMapper.addItem(item_id, item_name);
		return message;
	}
	@Override
	public int addCompany(String company_id,String company_name,String company_state,
			String item_img,String item_id)throws Exception{
		int message = backStageMapper.addCompany(company_id, company_name, 
				company_state, item_img, item_id);
		return message;
	}
	@Override
	public List<Items> findItems(String item_id)throws Exception{
		List<Items> items = backStageMapper.getItems(item_id);
		return items;
	}
	@Override
	public int updateItem(Items items) throws Exception{
		int message = backStageMapper.updateItem(items);
		return message;
	}
	@Override
	public String findCompanyImgUrl(String company_id) throws Exception{
		String company_img_url = backStageMapper.getCompanyImgUrl(company_id);
		return company_img_url;
	}
	@Override
	public int updateCompany(Company company) throws Exception{
		int message = backStageMapper.updateCompany(company);
		return message;
	}
	@Override
	public int addImage(Image image) throws Exception{
		int message = backStageMapper.addImage(image);
		return message;
	}
	@Override
	public List<Company> findAllCompany() throws Exception{
		List<Company> company = backStageMapper.getAllCompany();
		return company;
	}
	@Override
	public List<Image> finAllImageById(String company_id) throws Exception{
		List<Image> image = backStageMapper.getAllImageById(company_id);
		return image;
	}
	@Override
	public int updateImage(Image image) throws Exception{
		int message = backStageMapper.updateImage(image);
		return message;
	}
	@Override
	public String findImageUrl(String image_id) throws Exception{
		String image_url = backStageMapper.getImageUrl(image_id);
		return image_url;
	}
	@Override
	public Image findImageById(String image_id) throws Exception{
		Image image = backStageMapper.getImageById(image_id);
		return image;
	}
	@Override
	public int deleteItems(String item_id) throws Exception{
		int message = backStageMapper.deleteItems(item_id);
		return message;
	}
	@Override
	public int deleteCompany(String[] companyIdArr) throws Exception{
		int message = backStageMapper.deleteCompany(companyIdArr);
		return message;
	}
	@Override
	public int deleteImage(String[] imageIdArr) throws Exception{
		int message = backStageMapper.deleteImage(imageIdArr);
		return message;
	}
	@Override
	public String[] findAllCompanyId(String item_id) throws Exception{
		String[] itemidArr = backStageMapper.getAllCompanyId(item_id);
		return itemidArr;
	}
	@Override
	public String[] findAllImageId(String company_id) throws Exception{
		String[] companyidArr = backStageMapper.getAllImageId(company_id);
		return companyidArr;
	}
	@Override
	public List<Company> findOneCompany(String company_id) throws Exception {
		List<Company> company = backStageMapper.getOneCompany(company_id);
		return company;
	}
}

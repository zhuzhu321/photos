package com.liyujian.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.liyujian.dao.BackStageDao;
import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;
import com.liyujian.service.BackStageService;
@Service("backStageService")
public class BackStageServiceImpl implements BackStageService{
	@Resource
	private BackStageDao backStageDao;
	@Override
	public int addItem(String item_id, String item_name) throws Exception{
		int message = backStageDao.addItem(item_id, item_name);
		return message;
	}
	@Override
	public int addCompany(String company_id,String company_name,String company_state,
			String item_img,String item_id) throws Exception {
		int message = backStageDao.addCompany(company_id, company_name, 
				company_state, item_img, item_id);
		return message;
	}
	@Override
	public List<Items> findItems(String item_id) throws Exception {
		List<Items> items = backStageDao.findItems(item_id);
		return items;
	}
	@Override
	public int updateItem(Items items) throws Exception {
		int message = backStageDao.updateItem(items);
		return message;
	}
	@Override
	//删除公司的小图,一张
	public void removeCompanyImgById(String company_id,HttpServletRequest request) throws Exception {
		String  filePath = backStageDao.findCompanyImgUrl(company_id);
		/*if(filePath==null||filePath.isEmpty()) {
			return;
		}*/
		// 获得项目的路径  
        ServletContext sc = request.getSession().getServletContext();  
        //路径  
        String path = sc.getRealPath("/img");
        String remove="/liyujian/img";
        path=path.replace(remove, "")+filePath;
        System.out.println(path);
		//删除图片
        File file = new File(path);
        if (file.exists()){
        	file.delete();  
        }
	}
	//删除公司图片，多张
		public void removeCompanyImgById(String[] companyIdArr,HttpServletRequest request) throws Exception {
			for(int i=0;i<companyIdArr.length;i++){
			String  filePath = backStageDao.findCompanyImgUrl(companyIdArr[i]);
			// 获得项目的路径  
	        ServletContext sc = request.getSession().getServletContext();  
	        //路径  
	        String path = sc.getRealPath("/img");
	        String remove="/liyujian/img";
	        path=path.replace(remove, "")+filePath;
	        System.out.println(path);
			//删除图片
	        File file = new File(path);
	        if (file.exists()){
	        	System.out.println("文件存在");
	        	file.delete();  
	        }else {
	        	System.out.println("文件不存在");
	        }
			}
		}
	//删除图片,一张
	@Override
	public void removeImageUrlById(String image_id, HttpServletRequest request) throws Exception {
		String  filePath = backStageDao.findImageUrl(image_id);
		// 获得项目的路径  
        ServletContext sc = request.getSession().getServletContext();  
        //路径  
        String path = sc.getRealPath("/img");
        String remove="/liyujian/img";
        path=path.replace(remove, "")+filePath;
        System.out.println(path);
		//删除图片
        File file = new File(path);
        if (file.exists()){
        	file.delete();
        }
	}
	//删除图片,多张
		@Override
		public void removeImageUrlById(String[] imageIdArr, HttpServletRequest request) throws Exception {
			for(int i=0;i<imageIdArr.length;i++) {
			String  filePath = backStageDao.findImageUrl(imageIdArr[i]);
			// 获得项目的路径  
	        ServletContext sc = request.getSession().getServletContext();  
	      //路径  
	        String path = sc.getRealPath("/img");
	        String remove="/liyujian/img";
	        path=path.replace(remove, "")+filePath;
	        System.out.println(path);
			//删除图片
	        File file = new File(path);
	        if (file.exists()){
	        	file.delete();  
	        }
			}
		}
	@Override
	public int updateCompany(Company company) throws Exception {
		int message = backStageDao.updateCompany(company);
		return message;
	}
	@Override
	public int addImage(Image image) throws Exception {
		int message = backStageDao.addImage(image);
		return message;
	}
	@Override
	public List<Company> finAllCompany() throws Exception {
		List<Company> company = backStageDao.findAllCompany();
		return company;
	}
	@Override
	public List<Image> findAllImageById(String company_id) throws Exception {
		List<Image> iamge = backStageDao.finAllImageById(company_id);
		return iamge;
	}
	@Override
	public int updateImage(Image image) throws Exception {
		int message = backStageDao.updateImage(image);
		return message;
	}
	@Override
	public Image findImageById(String image_id) throws Exception {
		Image image = backStageDao.findImageById(image_id);
		return image;
	}
	@Override
	public void removeItemsById(String item_id) throws Exception {
		backStageDao.deleteItems(item_id);
		
	}
	@Override
	public void removeCompanyById(String[] companyIdArr) throws Exception {
		backStageDao.deleteCompany(companyIdArr);
		
	}
	@Override
	public void removeImageById(String[] imageIdArr) throws Exception {
		backStageDao.deleteImage(imageIdArr);
		
	}
	@Override
	public String[] findAllCompanyId(String item_id) throws Exception {
		String[] itemidArr = backStageDao.findAllCompanyId(item_id);
		return itemidArr;
	}
	@Override
	public String[] findAllImageId(String company_id) throws Exception {
		String[] companyidArr = backStageDao.findAllImageId(company_id);
		return companyidArr;
	}
	@Override
	public List<Company> findOneCompany(String company_id) throws Exception {
		List<Company> company = backStageDao.findOneCompany(company_id);
		return company;
	}
	
	
}

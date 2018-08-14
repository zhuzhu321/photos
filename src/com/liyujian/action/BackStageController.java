package com.liyujian.action;
import java.io.File;
import java.io.FileOutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.liyujian.exception.CustomException;
import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;
import com.liyujian.service.BackStageService;
import com.liyujian.utils.UUIDUtils;


@Controller
@Scope(value="prototype")
@RequestMapping("/manage")
public class BackStageController {
	@Resource
	private BackStageService backStageService;
	//添加一级分类数据
	@RequestMapping(value="/addItem",method=RequestMethod.POST)
	public @ResponseBody int addItem(String item_name) throws Exception {
		if(item_name==null||item_name.isEmpty()) {
			throw new CustomException("Please write the name of the items.");
		}
		String item_id = UUIDUtils.getUUID();
		int message = backStageService.addItem(item_id, item_name);
		return message;
	}
	
	//添加二级分类
	@RequestMapping(value="/addCompany",method=RequestMethod.POST)
	public @ResponseBody int addCompany(
			String company_name,
			String company_state,String item_id,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws Exception {
			if(file.isEmpty()||company_name==null||company_state==null||item_id==null) {
				throw new CustomException("请补全所需填写的信息！");
			}
			// 获得原始文件名  
	        String fileName = file.getOriginalFilename();
	        // 新文件名  
	        String newFileName = UUIDUtils.getUUID()+ fileName;
	        // 获得项目的路径  
	        ServletContext sc = request.getSession().getServletContext();  
	        // 上传位置  
	        String path = sc.getRealPath("/img")+"/"; // 设定文件保存的目录 
	        System.out.println(path);
	        File f = new File(path);  
	        if (!f.exists())  
	            f.mkdirs();  
	        if (!file.isEmpty()) { 
	            try {  
	                FileOutputStream fos = new FileOutputStream(path + newFileName);  
	                InputStream in = file.getInputStream();  
	                int b = 0;  
	                while ((b = in.read()) != -1) {  
	                    fos.write(b);  
	                }  
	                fos.close();  
	                in.close();
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	      
	      //插入数据到数据库
	        String company_id = UUIDUtils.getUUID();
	        String item_img = "/liyujian/img/"+newFileName;
	        System.out.println(item_img);
	      int message = backStageService.addCompany(company_id, company_name, 
	    		  company_state, item_img, item_id);
	      
		return message;
	}
	//获取一级分类
	@RequestMapping(value="/findItem",method=RequestMethod.GET)
	public @ResponseBody List<Items> findItem(String item_id) throws Exception{
		if(item_id==null||item_id.isEmpty()) {
			throw new CustomException("页面错误！");
		}
		List<Items> items = backStageService.findItems(item_id);
		return items;
	}
	//修改一级分类
	@RequestMapping(value="/editItem",method=RequestMethod.POST)
	public @ResponseBody int editItem(Items items) throws Exception{
		int message = backStageService.updateItem(items);
		return message;
	}
	//修改二级分类
	@RequestMapping(value="/editCompany",method=RequestMethod.POST)
	public @ResponseBody int editCompany(Company company,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws Exception{
		//如果修改了图片，1.先删除图片2.再上传图片3.再上传修改信息.
		if(!file.isEmpty()) {
			//1.删除图片
			backStageService.removeCompanyImgById(company.getCompany_id(),request);
			//2.上传图片
			// 获得原始文件名  
	        String fileName = file.getOriginalFilename();  
	        System.out.println("原始文件名:" + fileName);  
	  
	        // 新文件名  
	        String newFileName = UUIDUtils.getUUID()+ fileName;  
	        System.out.println("new文件名:" + newFileName); 
	        // 获得项目的路径  
	        ServletContext sc = request.getSession().getServletContext();  
	        // 上传位置  
	        String path = sc.getRealPath("/img")+"/"; // 设定文件保存的目录  
	        System.out.println("上传位置:" + path); 
	        File f = new File(path);  
	        if (!f.exists())  
	            f.mkdirs();  
	        if (!file.isEmpty()) {  
	            try {  
	                FileOutputStream fos = new FileOutputStream(path + newFileName);  
	                InputStream in = file.getInputStream();  
	                int b = 0;  
	                while ((b = in.read()) != -1) {  
	                    fos.write(b);  
	                }  
	                fos.close();  
	                in.close();  
	                System.out.println("上传成功"); 
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }
	        //设置图片的新路径
	        company.setItem_img("/liyujian/img/"+newFileName);
			}
		//3.上传修改信息
		int message = backStageService.updateCompany(company);
		return message;
	}
	//上传图片
	@RequestMapping(value="/addImage",method=RequestMethod.POST)
	public@ResponseBody int addImage(Image image,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws Exception{
		//判断前端是否上传了图片
		if(!file.isEmpty()) {
			//1.上传图片
			// 获得原始文件名  
	        String fileName = file.getOriginalFilename();  
	  
	        // 新文件名  
	        String newFileName = UUIDUtils.getUUID()+ fileName; 
			//设置数据库里的路径
	        image.setImage_url("/liyujian/img/"+newFileName);
	        // 获得项目的路径  
	        ServletContext sc = request.getSession().getServletContext();  
	        // 上传位置  
	        String path = sc.getRealPath("/img")+"/"; // 设定文件保存的目录  
	        System.out.println("上传位置:" + path); 
	        File f = new File(path);  
	        if (!f.exists())  
	            f.mkdirs();  
	        if (!file.isEmpty()) {  
	            try {  
	                FileOutputStream fos = new FileOutputStream(path + newFileName);  
	                InputStream in = file.getInputStream();  
	                int b = 0;  
	                while ((b = in.read()) != -1) {  
	                    fos.write(b);  
	                }  
	                fos.close();  
	                in.close();  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }
		}else {
			throw new CustomException("请添加一张图片！");
		}
		//设置上传时间为系统当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		image.setImage_uploadtime(df.format(new Date()));
		//设置image_id
		image.setImage_id(UUIDUtils.getUUID());
		int message = backStageService.addImage(image);
		return message;
	}
	//获取一个二级分类
	@RequestMapping(value="/findOneCompany",method=RequestMethod.GET)
	public@ResponseBody List<Company> findOneCompany(String company_id) throws Exception{
		List<Company> company = backStageService.findOneCompany(company_id);
		
		return company;
	}
	//获取所有二级分类,及分类下的所有图片
	@RequestMapping(value="/findAllCompany",method=RequestMethod.GET)
	public@ResponseBody List<Company> findAllCompany() throws Exception{
		List<Company> company = backStageService.finAllCompany();
		for(Company parent : company) {
			// 查询出当前父分类的所有子分类
			List<Image> company_children = backStageService.findAllImageById(parent.getCompany_id());
			// 设置给父分类
			parent.setCompany_children(company_children);
		}
		return company;
	}
	//修改图片实体
	@RequestMapping(value="/editImage",method=RequestMethod.POST)
	public@ResponseBody int editImage(Image image,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request
			) throws Exception{
				//如果修改了图片，1.先删除图片2.再上传图片3.再上传修改信息；如果没有修改图片就
				if(!file.isEmpty()) {
					//1.删除图片
					backStageService.removeImageUrlById(image.getImage_id(),request);
					//2.上传图片
					// 获得原始文件名  
			        String fileName = file.getOriginalFilename();
			        // 新文件名  
			        String newFileName = UUIDUtils.getUUID()+ fileName;  
			        // 获得项目的路径  
			        ServletContext sc = request.getSession().getServletContext();  
			        // 上传位置  
			        String path = sc.getRealPath("/img")+"/"; // 设定文件保存的目录  
			        File f = new File(path);  
			        if (!f.exists())  
			            f.mkdirs();  
			        if (!file.isEmpty()) {  
			            try {  
			                FileOutputStream fos = new FileOutputStream(path + newFileName);  
			                InputStream in = file.getInputStream();  
			                int b = 0;  
			                while ((b = in.read()) != -1) {  
			                    fos.write(b);  
			                }  
			                fos.close();  
			                in.close();  
			            } catch (Exception e) {  
			                e.printStackTrace();  
			            }  
			        }
			        //设置图片的新路径
			        image.setImage_url("/liyujian/img/"+newFileName);
			        //设置上传时间为系统当前时间
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					image.setImage_uploadtime(df.format(new Date()));
					}
				//3.上传修改信息
				int message = backStageService.updateImage(image);
				return message;
	}
	//通过image_id查找image
	@RequestMapping(value="/findImage",method=RequestMethod.GET)
	public@ResponseBody Image findImage(String image_id) throws Exception{
		Image image = backStageService.findImageById(image_id);
		return image;
	}
	//删除一级分类
	@RequestMapping(value="/deleteItems",method=RequestMethod.POST)
	public@ResponseBody void deleteItems(String item_id,
			HttpServletRequest request) throws Exception{
		/*
		要删除一级分类，就要先删除3级子类，再删2级分类，最后删除一级分类
        */
		//1.先找到所有二级分类
		String [] companyIdArr = backStageService.findAllCompanyId(item_id);
		//2.根据company_id删除图片,及服务器上的图片
		if(companyIdArr.length!=0) {
		for(int i=0;i<companyIdArr.length;i++) {
			//2.1找到所有图片的id
			String [] imageIdArr = backStageService.findAllImageId(companyIdArr[i]);
			if(imageIdArr.length!=0) {
			//2.2删除服务器上的图片
			backStageService.removeImageUrlById(imageIdArr, request);
			//2.3删除数据库的记录
			backStageService.removeImageById(imageIdArr);
			}
		}
		
		//3.删除二级分类，及服务器上的图片
		//先删除图片，后删除记录
		backStageService.removeCompanyImgById(companyIdArr, request);
		backStageService.removeCompanyById(companyIdArr);
		
		}
		//4.删除一级分类
		backStageService.removeItemsById(item_id);
		
	}
	//删除二级分类
	@RequestMapping(value="/deleteCompany",method=RequestMethod.POST)
	public@ResponseBody void deleteCompany(String company_id,
			HttpServletRequest request) throws Exception{
		//先删3级分类，最后删除2级分类
		//1.s删除服务器上的
		String [] imageIdArr = backStageService.findAllImageId(company_id);
		
		if(imageIdArr.length!=0) {
		backStageService.removeImageUrlById(imageIdArr, request);
		}
		//2.删除数据库里的记录
		String[] companyIdArr = {company_id};
		if(imageIdArr.length!=0) {
		backStageService.removeImageById(imageIdArr);
		}
		//删除2级分类
		//先删除服务器上的图片
		backStageService.removeCompanyImgById(company_id, request);
		//再删除数据库里的记录
		backStageService.removeCompanyById(companyIdArr);
		
	}
	//删除3级分类
	@RequestMapping(value="/deleteImage",method=RequestMethod.POST)
	public@ResponseBody void deleteImage(String image_id,
			HttpServletRequest request) throws Exception{
		
		//1.删除服务器上的图片
		backStageService.removeImageUrlById(image_id, request);
		//2.删除数据库的记录
		String[] imageIdArr = {image_id};
		backStageService.removeImageById(imageIdArr);
	}
}

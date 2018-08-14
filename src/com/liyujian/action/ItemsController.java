package com.liyujian.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyujian.exception.CustomException;
import com.liyujian.po.Company;
import com.liyujian.po.Image;
import com.liyujian.po.Items;
import com.liyujian.service.ItemsService;


@Controller
@Scope(value="prototype")
@RequestMapping("/items")
public class ItemsController {
	@Resource
	private ItemsService itemsService;
	//查询所有分类
	@RequestMapping(value="/findItems",method=RequestMethod.GET)
	public@ResponseBody List<Items> findItems() throws Exception{
		List<Items> items=(List<Items>) itemsService.findItems();
		/*
		 * 2. 循环遍历所有的一级分类，为每个一级分类加载它的二级分类 
		 */
		for(Items parent : items) {
			// 查询出当前父分类的所有子分类
			List<Company> item_children = itemsService.findItemsChilderen(parent.getItem_id());
			// 设置给父分类
			parent.setItem_children(item_children);
		}
        return items;
    }
	
	//根据父分类查询子分类
	@RequestMapping(value="/findChildren",method=RequestMethod.GET)
	public@ResponseBody List<Company> findChildren(String item_id) throws Exception{
		List<Company> company = itemsService.findItemsChilderen(item_id);
		return company;
	}
	
	//根据company_id查询Image
	@RequestMapping(value="/findImage",method=RequestMethod.GET)
	public@ResponseBody List<Image> findImage(String company_id) throws Exception{
		List<Image> image = itemsService.findImageById(company_id);
		if(null == image || image.size() ==0 ) {
			throw new CustomException("Don't have photos,please upload some photos!");
		}
		return image;
	}
}

package com.liyujian.po;

import java.util.List;

public class Company {
	private String company_id;
	private String company_name;
	private String company_state;
	private String item_img;
	private String item_id;
	private List<Image> company_children;
	
	public List<Image> getCompany_children() {
		return company_children;
	}
	public void setCompany_children(List<Image> company_children) {
		this.company_children = company_children;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_state() {
		return company_state;
	}
	public void setCompany_state(String company_state) {
		this.company_state = company_state;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	
}

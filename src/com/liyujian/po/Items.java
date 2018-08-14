package com.liyujian.po;

import java.util.List;

public class Items {
	private String item_id;
	private String item_name;
	private List<Company> item_children;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public List<Company> getItem_children() {
		return item_children;
	}
	public void setItem_children(List<Company> item_children) {
		this.item_children = item_children;
	}
}

package org.example.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.example.bean.ItemBean;
import org.example.service.ItemService;

import java.util.ArrayList;


public class ItemAction extends ActionSupport implements ModelDriven<ItemBean> {

	private static final long serialVersionUID = 1L;
	private ItemBean itemBean = new ItemBean();
	private ArrayList<ItemBean> list;
	public ArrayList<ItemBean> getList() {
		return list;
	}
	public void setList(ArrayList<ItemBean> list) {
		this.list = list;
	}
	public ItemBean getModel() {
		return itemBean;
	}
	public String getAllItems(){
		ItemService itemServ = new ItemService();
		list = itemServ.getAllItems();
		System.out.println("ItemAction is running!");
		return SUCCESS;
	}
}

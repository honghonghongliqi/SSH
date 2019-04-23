package org.example.service;



import org.example.bean.ItemBean;

import java.util.ArrayList;

public class ItemService {
	public ArrayList<ItemBean> getAllItems(){
		ArrayList<ItemBean> list = new ArrayList<ItemBean>();
		list.add(new ItemBean("�����","001", 25));
		list.add(new ItemBean("Java","002", 45));
		list.add(new ItemBean("C","003", 22));
		list.add(new ItemBean("����","004", 89));
		return list;
	}
}

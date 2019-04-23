package org.example.bean;

public class ItemBean {
	private String name;
	private String number;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ItemBean(String name, String number, int price) {
		super();
		this.name = name;
		this.number = number;
		this.price = price;
	}
	public ItemBean() {
		super();
	}
}

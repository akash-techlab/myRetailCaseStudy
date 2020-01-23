package com.casestudy.myRetail.domain;

public class ProductDetails {

	private int id;
	private String name;
	private CurrentPrice current_price;

	public CurrentPrice getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(CurrentPrice current_price) {
		this.current_price = current_price;
	}

	public ProductDetails() {
	}

	public ProductDetails(int id, String name, CurrentPrice current_price) {
		this.id = id;
		this.name = name;
		this.current_price = current_price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

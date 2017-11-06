package com.sg.assignment;

public class Product {

	
	private long id;
	private double price;
	private String brand;
	private String type;
	
	public Product(long id, String brand, String type, double price) {
		super();
		this.id = id;
		this.price = price;
		this.brand = brand;
		this.type = type;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String  brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

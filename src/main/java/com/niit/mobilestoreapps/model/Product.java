package com.niit.mobilestoreapps.model;

public class Product {
	private int product_id,brand_id;
	private String product_name,product_description1,product_description2;
	private double product_price;
	private double product_discount;
	
	public Product()
	{
		
	}
	public Product(int product_id,int brand_id, String product_name, String product_description1,
			String product_description2, double product_price, double product_discount) {
		
		this.product_id = product_id;
		this.brand_id = brand_id;
		this.product_name = product_name;
		this.product_description1 = product_description1;
		this.product_description2 = product_description2;
		this.product_price = product_price;
		this.product_discount = product_discount;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description1() {
		return product_description1;
	}
	public void setProduct_description1(String product_description1) {
		this.product_description1 = product_description1;
	}
	public String getProduct_description2() {
		return product_description2;
	}
	public void setProduct_description2(String product_description2) {
		this.product_description2 = product_description2;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public double getProduct_discount() {
		return product_discount;
	}
	public void setProduct_discount(double product_discount) {
		this.product_discount = product_discount;
	}

}

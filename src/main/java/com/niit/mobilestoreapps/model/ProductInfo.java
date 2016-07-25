package com.niit.mobilestoreapps.model;

public class ProductInfo {

	private int code;
	private String name;
	private double price;
	private String imgname;

	private boolean newProduct = false;
	
	public ProductInfo() {
	}
	public ProductInfo(Product product) {
		this.code = product.getProduct_id();
		this.name = product.getProduct_name();
		this.price = product.getProduct_price();
		this.imgname = product.getProduct_image();
	}
	public ProductInfo(int code, String name, double price, String imgname, boolean newProduct) {
	
		this.code = code;
		this.name = name;
		this.price = price;
		this.imgname = imgname;
		this.newProduct = newProduct;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public boolean isNewProduct() {
		return newProduct;
	}
	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}

}

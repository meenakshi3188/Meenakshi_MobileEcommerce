package com.niit.mobilestoreapps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="ProductBrand")
public class ProductBrand {
	
	@Id
	@Column(name="brand_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brand_id;
	
	@Column(name="brand_name")
	@NotEmpty(message="Brand name should not be blank")
	private String brand_name;
	
	public ProductBrand()
	{
		//System.out.println("hi");
	}
	
	public ProductBrand(int brand_id, String brand_name) {	
		this.brand_id = brand_id;
		this.brand_name = brand_name;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

}

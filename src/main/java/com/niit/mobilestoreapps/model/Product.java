package com.niit.mobilestoreapps.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;


@Entity
	@Table(name="Product")
	public class Product {
		
		@Id
		@Column(name="product_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int product_id;
		
		@Column(name="brand_id")
		private int brand_id;
		
		@Column(name="supp_id")
		private int supp_id;
		
		@Column(name="product_name")
		private String product_name;
		
		@Column(name="product_description1")
		private String product_description1;
		
		@Column(name="product_description2")
		private String product_description2;
		
		@Column(name="product_model")
		private String product_model;
		
		@Column(name="product_price")
		private double product_price;
		
		@Column(name="product_discount")
		private double product_discount;
		
		@Column(name="product_flag")
		private boolean product_flag;

		
		@Column(name="product_image")
		private String prod_image;
		
		transient private MultipartFile prod_file;
		
		public Product()
		{
			
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
		public int getSupp_id() {
			return supp_id;
		}

		public void setSupp_id(int supp_id) {
			this.supp_id = supp_id;
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
		
		public String getProduct_model() {
			return product_model;
		}

		public void setProduct_model(String product_model) {
			this.product_model = product_model;
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

		public boolean isProduct_flag() {
			return product_flag;
		}

		public void setProduct_flag(boolean product_flag) {
			this.product_flag = product_flag;
		}


		public String getProd_image() {
			return prod_image;
		}

		public void setProd_image(String prod_image) {
			this.prod_image = prod_image;
		}

		public MultipartFile getProd_file() {
			return prod_file;
		}

		public void setProd_file(MultipartFile prod_file) {
			this.prod_file = prod_file;
		}
		public Product(int product_id, int brand_id, String product_name, String product_description1,
				String product_description2, String product_model, double product_price, double product_discount,
				boolean product_flag) {
			super();
			this.product_id = product_id;
			this.brand_id = brand_id;
			this.product_name = product_name;
			this.product_description1 = product_description1;
			this.product_description2 = product_description2;
			this.product_model = product_model;
			this.product_price = product_price;
			this.product_discount = product_discount;
			this.product_flag = product_flag;
		}
		public String getFilePath(String path1,String contextPath)
		{
			String fileName;
			
			if(!prod_file.isEmpty())
			{
				try
				{
					fileName=prod_file.getOriginalFilename();
					
					byte[] bytes=prod_file.getBytes();
					
					String npath=path1+"\\resources\\"+fileName;
				
					BufferedOutputStream buffStream=new BufferedOutputStream(new FileOutputStream(new File(npath)));
					
					buffStream.write(bytes);	
					buffStream.close();
					String dbfilename=contextPath+"/resources/"+fileName;
					setProd_image(dbfilename);
					
					return dbfilename;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(e.getMessage());
					return "fail";
				}
			}
			else
			{
				return "fail";
			}
		}
}

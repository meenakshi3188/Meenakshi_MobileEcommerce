package com.niit.mobilestoreapps.service;

import java.util.List;

import com.niit.mobilestoreapps.model.ProductBrand;

public interface BrandService
{
	public List<ProductBrand> showBrand();
	public ProductBrand getNameById(int id); 
	public void savebrand(ProductBrand obj);	
	
}
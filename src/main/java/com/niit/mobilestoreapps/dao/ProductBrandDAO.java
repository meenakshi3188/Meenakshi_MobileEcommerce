package com.niit.mobilestoreapps.dao;

import java.util.List;

import com.niit.mobilestoreapps.model.ProductBrand;

public interface ProductBrandDAO
{
	public List<ProductBrand> showBrand();
	public ProductBrand getNameById(int id); 
	public void savebrand(ProductBrand obj);	
}
package com.niit.mobilestoreapps.dao;

import java.util.List;

import com.niit.mobilestoreapps.model.Product;

public interface ProductDAO {
	public List<Product> showProduct();
	public Product getNameById(int id); 
	public void saveOrUpdate(Product p);
	public void delete(int id);
	
	
	
}

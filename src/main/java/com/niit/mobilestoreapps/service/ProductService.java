package com.niit.mobilestoreapps.service;

import java.util.List;

import com.niit.mobilestoreapps.model.Product;

public interface ProductService {
	
	public List<Product> showProduct();
	public Product getNameById(int id); 
	public void saveOrUpdate(Product p);
	public void delete(int id);

}

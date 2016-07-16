package com.niit.mobilestoreapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilestoreapps.dao.ProductDAO;
import com.niit.mobilestoreapps.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO pdao;
	
	@Transactional
	public List<Product> showProduct() {
		return pdao.showProduct();
	}

	@Transactional
	public Product getNameById(int id) {
		return pdao.getNameById(id);
	}

	@Transactional
	public void saveOrUpdate(Product p) {
		//System.out.println("in service impl");
		pdao.saveOrUpdate(p);
		
	}

	@Transactional
	public void delete(int id) {
		pdao.delete(id);
		
	}

	@Transactional
	public List<Product> getProductByBrandId(int id) {
		return pdao.getProductByBrandId(id);
	}

	@Transactional
	public void updateProduct(Product prd) {
		pdao.updateProduct(prd);
		
	}
	

}

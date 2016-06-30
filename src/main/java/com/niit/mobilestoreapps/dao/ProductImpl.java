package com.niit.mobilestoreapps.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobilestoreapps.model.Product;
@Repository
public class ProductImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> showProduct() {
		
		return (List<Product>)sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	public Product getNameById(int id) {
		
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public void saveOrUpdate(Product p) {
		sessionFactory.getCurrentSession().saveOrUpdate(p);
		
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(id);
	}

}

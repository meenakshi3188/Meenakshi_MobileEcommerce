package com.niit.mobilestoreapps.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobilestoreapps.model.ProductBrand;
@Repository
public class ProductBrandImpl implements ProductBrandDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ProductBrand> showBrand() 
	{
		return (List<ProductBrand>)sessionFactory.getCurrentSession().createQuery("from ProductBrand").list();
	}
	public void savebrand(ProductBrand obj) {
		sessionFactory.getCurrentSession().save(obj);
		sessionFactory.getCurrentSession().flush();
	} 
	
	public ProductBrand getNameById(int id) {
		return (ProductBrand)sessionFactory.getCurrentSession().load(ProductBrand.class, new Integer(id));
	}
	@Override
	public void updateBrand(ProductBrand p) {
		sessionFactory.getCurrentSession().update(p);
		
	}
}
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
		//System.out.println("in product impl");
		//System.out.println(p.getProduct_image());
		sessionFactory.getCurrentSession().saveOrUpdate(p);
	}

	@Override
	public void delete(int id) {
		//sessionFactory.getCurrentSession().delete(id);
		sessionFactory.getCurrentSession().createQuery("delete from Product where product_id = " + id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductByBrandId(int id) {
		System.out.println(id);
		List<Product> dbset = sessionFactory.getCurrentSession().createQuery("from Product where brand_id = " + id).list();	
		return dbset;
	}

	@Override
	public void updateProduct(Product prd) {
		sessionFactory.getCurrentSession().update(prd);
		
	}
}

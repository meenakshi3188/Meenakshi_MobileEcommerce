package com.niit.mobilestoreapps.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobilestoreapps.model.ProductBrand;
@Repository
public class ProductBrandImpl implements ProductBrandDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@SuppressWarnings("unchecked")
	public List<ProductBrand> showBrand() 
	{
		return (List<ProductBrand>)sessionFactory.getCurrentSession().createQuery("from ProductBrand").list();
	}
	@Override
	public void savebrand(ProductBrand obj) {
		sessionFactory.getCurrentSession().save(obj);
		sessionFactory.getCurrentSession().flush();
	} 
	@Override
	public ProductBrand getNameById(int id) {
		//System.out.println("In implementation :" + id);
		
		Session session = sessionFactory.getCurrentSession();
		return (ProductBrand)session.get(ProductBrand.class, new Integer(id));
		
	}
	@Override
	public void updateBrand(ProductBrand p) {
		sessionFactory.getCurrentSession().update(p);
		//sessionFactory.getCurrentSession().flush();
	}
	@Override
	public void delete(int id) {
		//System.out.println(id);
		sessionFactory.getCurrentSession().createQuery("delete from ProductBrand where brand_id = " + id).executeUpdate();
	}
}
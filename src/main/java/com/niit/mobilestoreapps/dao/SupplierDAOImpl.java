package com.niit.mobilestoreapps.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.mobilestoreapps.model.Supplier;
@Repository
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@SuppressWarnings("unchecked")
	public List<Supplier> showSupplier() {
		
		return (List<Supplier>)sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	@Override
	public Supplier getNameById(int id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, new Integer(id));
	}

	@Override
	public void saveSupplier(Supplier obj) {
		//System.out.println("in service impl");
		sessionFactory.getCurrentSession().save(obj);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateSupplier(Supplier sup) {
		sessionFactory.getCurrentSession().update(sup);
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession().createQuery("delete from Supplier where supp_id = " + id).executeUpdate();
	}
	

}

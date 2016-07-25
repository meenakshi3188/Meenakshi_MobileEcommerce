package com.niit.mobilestoreapps.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobilestoreapps.model.Cart;
@Repository
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Cart> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Cart cart) {
		System.out.println("in dao" + cart.getProductName());
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalAmount(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

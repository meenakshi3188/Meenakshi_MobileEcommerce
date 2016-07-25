package com.niit.mobilestoreapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilestoreapps.dao.CartDAO;
import com.niit.mobilestoreapps.model.Cart;
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDAO cdao;
	
	@Transactional
	public List<Cart> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Cart get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		System.out.println("in service" + cart.getProductName());
		cdao.saveOrUpdate(cart);
		
	}

	@Transactional
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public int getTotalAmount(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

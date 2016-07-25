package com.niit.mobilestoreapps.service;

import java.util.List;

import com.niit.mobilestoreapps.model.Cart;

public interface CartService {
	public List<Cart> list();

	public Cart get(String id);
	public void saveOrUpdate(Cart cart);

	public String delete(String id);
	
	public int getTotalAmount(String id);

}

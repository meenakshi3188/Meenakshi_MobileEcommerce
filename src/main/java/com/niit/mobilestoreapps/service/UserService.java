package com.niit.mobilestoreapps.service;

import com.niit.mobilestoreapps.model.User_Details;

public interface UserService {
	public void saveOrUpdate(User_Details userDetails);

	public void delete(int id);
	
	public boolean isValidUser(int id, String password, boolean isAdmin);
}

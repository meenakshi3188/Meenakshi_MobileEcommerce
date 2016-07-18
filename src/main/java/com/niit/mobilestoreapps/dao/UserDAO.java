package com.niit.mobilestoreapps.dao;

import com.niit.mobilestoreapps.model.User_Details;

public interface UserDAO {

	public void saveOrUpdate(User_Details userDetails);

	public void delete(int id);
	
	public boolean isValidUser(int id, String password, boolean isAdmin);
}

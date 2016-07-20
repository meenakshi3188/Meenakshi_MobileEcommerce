package com.niit.mobilestoreapps.dao;

import java.util.List;

import com.niit.mobilestoreapps.model.User_Details;

public interface UserDAO {

	public void saveOrUpdate(User_Details userDetails);

	public void delete(int id);
	
	public boolean isValidUser(String username, String password, boolean isAdmin);
	
	public List<User_Details> getUsernameList();
}

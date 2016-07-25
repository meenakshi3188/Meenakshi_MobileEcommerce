package com.niit.mobilestoreapps.service;

import java.util.List;

import com.niit.mobilestoreapps.model.User;
import com.niit.mobilestoreapps.model.User_Details;

public interface UserService {
	
	public void saveOrUpdate(User_Details userDetails);

	public void delete(int id);
	
	public boolean isValidUser(String username, String password, boolean isAdmin);
	
	public List<User_Details> getUsernameList();
	public void saveOrUpdate(User user);
}

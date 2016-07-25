package com.niit.mobilestoreapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilestoreapps.dao.UserDAO;
import com.niit.mobilestoreapps.model.User;
import com.niit.mobilestoreapps.model.User_Details;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO uDao;

	@Transactional
	public void saveOrUpdate(User_Details userDetails) {
		uDao.saveOrUpdate(userDetails);
		
	}

	@Transactional
	public void delete(int id) {
		uDao.delete(id);
	}

	@Transactional
	public boolean isValidUser(String username, String password, boolean isAdmin) {
		
		return uDao.isValidUser(username, password, isAdmin);
	}

	@Transactional
	public List<User_Details> getUsernameList() {
		return uDao.getUsernameList();
	
	}

	@Transactional
	public void saveOrUpdate(User user) {
		uDao.saveOrUpdate(user);
		
	}

}

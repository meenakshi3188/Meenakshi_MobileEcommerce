package com.niit.mobilestoreapps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilestoreapps.dao.UserDAO;
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
	public boolean isValidUser(int id, String password, boolean isAdmin) {
		
		return false;
	}

}

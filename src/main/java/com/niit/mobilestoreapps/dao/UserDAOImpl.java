package com.niit.mobilestoreapps.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobilestoreapps.model.User_Details;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(User_Details userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
		
	}

	@Override
	public void delete(int id) {
		
		sessionFactory.getCurrentSession().delete(id);
	}

	@Override
	public boolean isValidUser(int id, String password, boolean isAdmin) {
		
		return false;
	}

}
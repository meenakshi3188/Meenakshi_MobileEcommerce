package com.niit.mobilestoreapps.dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobilestoreapps.model.User;
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
	public boolean isValidUser(String username, String password, boolean isAdmin) {
		
		String hql = "from User where username= '" + username + "' and " + " password ='" + password+"'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_Details> getUsernameList() {
		return (List<User_Details>) sessionFactory.getCurrentSession().createCriteria("from User_Details").list();
	}

	@Override
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}

}

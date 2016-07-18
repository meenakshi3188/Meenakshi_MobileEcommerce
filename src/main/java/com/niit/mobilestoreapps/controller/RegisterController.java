package com.niit.mobilestoreapps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilestoreapps.model.User_Details;
import com.niit.mobilestoreapps.service.UserServiceImpl;

@Controller
public class RegisterController {
	
	@Autowired
	UserServiceImpl user_srv;
	
	@RequestMapping(value = "/register")
	public ModelAndView getLogin(){
		System.out.println("In register controller");
		return new ModelAndView("/register");
	
	}
	
	@RequestMapping(value = "/registerUser")
	public ModelAndView registerUser(@ModelAttribute User_Details userDetails)
	{
		System.out.println("In register user");
		ModelAndView mv=new ModelAndView("index");
		user_srv.saveOrUpdate(userDetails);
		return mv;
	}
}

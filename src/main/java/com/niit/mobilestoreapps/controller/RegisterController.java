package com.niit.mobilestoreapps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilestoreapps.model.User;
import com.niit.mobilestoreapps.model.User_Details;
import com.niit.mobilestoreapps.service.UserService;


@Controller
public class RegisterController {
	
	@Autowired
	UserService user_srv;
	
	//User u;
	
	@RequestMapping(value = "/register")
	public ModelAndView getLogin(){
		System.out.println("In register controller");
		return new ModelAndView("/register");
	}
	
	@ModelAttribute("register_user")
	public User_Details get_modelAttribute()
	{
		//System.out.println("In register user1");
		return new User_Details();
	}

	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("register_user") User_Details userDetails)
	{
		//System.out.println("In register user");
		String msg;
		//System.out.println(userDetails.getUsername());
		
		 ModelAndView mv=new ModelAndView("index");
			 
			 List<User_Details> lst=user_srv.getUsernameList();
				
				for(User_Details u:lst)
				{
					if(!(u.getUsername().equals(userDetails.getUsername())))
					{
						//user_srv.saveOrUpdate(userDetails);
						System.out.println("iff");
						msg="User Created Successfully";
						mv.addObject("message", msg);		
					}
					else
					{
						System.out.println("else");
						msg="User Already Existed";
						mv.addObject("message", msg);	
					}
				}
				return mv;
	}
}

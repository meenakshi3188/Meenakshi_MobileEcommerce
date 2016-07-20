package com.niit.mobilestoreapps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilestoreapps.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService user_srv;
	
	@RequestMapping(value = "/login")
	public ModelAndView getLogin(){
		return new ModelAndView("/login");
	}
	
	
	 @RequestMapping("/isValidUser")
		public ModelAndView isValidUser(@RequestParam(value = "username") String username,
				@RequestParam(value = "password") String password) {
			System.out.println("in controller");

			String message;
			ModelAndView mv ;
			if (user_srv.isValidUser(username, password,false)) 
			{
				message = "Valid credentials";
				 mv = new ModelAndView("home");
			} else {
				message = "Invalid credentials";
				 mv = new ModelAndView("login");
			}

			mv.addObject("message", message);
			mv.addObject("name", username);
			return mv;
		}
}

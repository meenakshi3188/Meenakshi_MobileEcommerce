package com.niit.mobilestoreapps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	@RequestMapping(value = "/register")
	public ModelAndView getLogin(){
		return new ModelAndView("/register");
	}

}

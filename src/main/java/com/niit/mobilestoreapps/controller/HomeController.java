package com.niit.mobilestoreapps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView StartPage(){
		//System.out.println("In Controller");
		return new ModelAndView("index");
	}
	
}
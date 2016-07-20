package com.niit.mobilestoreapps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	
	@RequestMapping(value = "/cart/{id}")
	public ModelAndView getCart(){
		return new ModelAndView("/cart");
	}
	

}

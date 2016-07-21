package com.niit.mobilestoreapps.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	
	@RequestMapping(value = "/cart/{id}")
	public ModelAndView getCart(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("index");
		Principal principal = request.getUserPrincipal();
		if(principal == null)
		{
			return new ModelAndView("login");
		}
		return mv;
		//return new ModelAndView("/cart");
	}
	

}

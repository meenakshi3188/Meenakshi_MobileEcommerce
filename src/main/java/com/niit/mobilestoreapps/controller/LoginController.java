package com.niit.mobilestoreapps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.mobilestoreapps.model.Product;
import com.niit.mobilestoreapps.model.ProductBrand;
import com.niit.mobilestoreapps.service.BrandService;
import com.niit.mobilestoreapps.service.ProductService;
import com.niit.mobilestoreapps.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService user_srv;

	@Autowired
	BrandService brndSrv;

	@Autowired
	ProductService prod_srv;

	/*
	 * @RequestMapping(value = "/login") 
	 * public ModelAndView getLogin(){
	 * ModelAndView mv=new ModelAndView("/login"); List<ProductBrand> lsts1 =
	 * brndSrv.showBrand(); mv.addObject("brandsLst1", lsts1); List<Product>
	 * lst=prod_srv.showProduct(); mv.addObject("prdLst", lst);
	 *  return mv; }
	 */

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "authfailed", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, HttpServletRequest request)
	{
		//System.out.println(error);
		
		ModelAndView view;
		
		/*ModelAndView view=new ModelAndView("/login");
		List<ProductBrand> lsts2 = brndSrv.showBrand();
		view.addObject("brandsLst1", lsts2);
		List<Product> lst3=prod_srv.showProduct();
		view.addObject("prdLst", lst3);
		*/
		if (error != null) {
			model.addAttribute("error", "Invalid username and password");
			view = new ModelAndView("login");
		} else if (logout != null) {
			view = new ModelAndView("index");
			List<ProductBrand> lsts1 = brndSrv.showBrand();
			view.addObject("brandsLst1", lsts1);
			List<Product> lst=prod_srv.showProduct();
			view.addObject("prdLst", lst);
			model.addAttribute("msg", "You have been logged out successfully.");
		} else {
			view = new ModelAndView("login");
		}
		return view;
	}

	@RequestMapping("/isValidUser")
	public ModelAndView isValidUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		//System.out.println("in controller");

		String message;
		ModelAndView mv;
		if (user_srv.isValidUser(username, password, false)) {
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

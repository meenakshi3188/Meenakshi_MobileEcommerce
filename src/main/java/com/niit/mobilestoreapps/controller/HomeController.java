package com.niit.mobilestoreapps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilestoreapps.dao.ProductDAO;
import com.niit.mobilestoreapps.model.Product;
import com.niit.mobilestoreapps.model.ProductBrand;
import com.niit.mobilestoreapps.service.BrandService;
import com.niit.mobilestoreapps.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	BrandService brndSrv;

	@Autowired
	ProductService prod_srv;
	
	@Autowired
	ProductDAO pdao;
	
	@RequestMapping("/")
	public ModelAndView StartPage(){
		
		ModelAndView mv=new ModelAndView("index");
		List<ProductBrand> lsts1 = brndSrv.showBrand();
		mv.addObject("brandsLst1", lsts1);
		List<Product> lst=prod_srv.showProduct();
		mv.addObject("prdLst", lst);
		return mv;
		
	}
	
	
	
	@RequestMapping(value = "/contact")
	public ModelAndView getContact(){
		return new ModelAndView("/contact");
		
	}
	@RequestMapping(value = "/about")
	public ModelAndView getAbout(){
		return new ModelAndView("/about");
		
	}
	
	@RequestMapping(value="/brandWiseProduct/{id}")
	public ModelAndView showAllProducts(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("brandWiseProduct");
		List<Product> lst2=prod_srv.getProductByBrandId(id);
		mv.addObject("prdLst", lst2);	
		return mv;
	}
}
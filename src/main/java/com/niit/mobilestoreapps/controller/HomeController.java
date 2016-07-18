package com.niit.mobilestoreapps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		System.out.println("In Controller");
		ModelAndView mv=new ModelAndView("index");
		List<ProductBrand> lsts1 = brndSrv.showBrand();
		mv.addObject("brandsLst1", lsts1);
		List<Product> lst=prod_srv.showProduct();
		mv.addObject("prdLst", lst);
		return mv;
		
	}
	
	
}
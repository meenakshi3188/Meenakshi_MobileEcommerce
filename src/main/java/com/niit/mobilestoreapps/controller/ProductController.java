package com.niit.mobilestoreapps.controller;

import java.util.List;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilestoreapps.model.Product;
import com.niit.mobilestoreapps.model.ProductBrand;
import com.niit.mobilestoreapps.model.Supplier;
import com.niit.mobilestoreapps.service.BrandService;
import com.niit.mobilestoreapps.service.ProductService;
import com.niit.mobilestoreapps.service.SupplierService;


@Controller
public class ProductController {
	
	@Autowired
	ProductService prod_srv;
	
	@Autowired
	ServletContext srv;
	
	@Autowired
	BrandService brndSrv;
	
	@Autowired
	SupplierService suppSrv;
	
	@RequestMapping(value = "/product")
	public ModelAndView product(){
		ModelAndView mv=new ModelAndView("Product");
		List<ProductBrand> lsts = brndSrv.showBrand();
		List<Supplier> lsts1 = suppSrv.showSupplier();
		mv.addObject("brands", lsts);
		mv.addObject("supplier", lsts1);
		return mv;
	}
	
	@ModelAttribute("save_product")
	public Product get_modelAttribute()
	{
		return new Product();
	}
	
	@RequestMapping(value= "/saveproduct", method = RequestMethod.POST)
	public ModelAndView savebrand(@Valid @ModelAttribute("save_product")Product p,BindingResult result){
		ModelAndView mv;
		 
		 if (result.hasErrors()) {
             return new ModelAndView("Product");
		 } else {
			
             String path = srv.getRealPath("/");
             //System.out.println("path=" + path);
             String res = p.getFilePath(path, srv.getContextPath());
            // System.out.println("res="+res);
             if (res == "fail")
             {
                 return new ModelAndView("Product");
             }
             else {
            	 
            	 prod_srv.saveOrUpdate(p);
            	 
                // List<Product> lsts = prod_srv.showProduct();
                 //return new ModelAndView("ProductLists", "prdList", lsts);
            	 mv = new ModelAndView("index");
            	 return mv;
             }
		 }
		
		}
	
}

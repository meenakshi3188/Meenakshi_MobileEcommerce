package com.niit.mobilestoreapps.controller;

import java.util.List;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView product(Model model){
		
		ModelAndView mv=new ModelAndView("Product");
		List<ProductBrand> lsts = brndSrv.showBrand();
		List<Supplier> lsts1 = suppSrv.showSupplier();
		List<Product> lsts2 = prod_srv.showProduct();
		mv.addObject("brands", lsts);
		mv.addObject("supplier", lsts1);	
        mv.addObject("ProductLists", lsts2);
        model.addAttribute("brands1", new ProductBrand());
       
		return mv;
	}
	
	@ModelAttribute("save_product")
	public Product get_modelAttribute()
	{
		return new Product();
	}
	
	@RequestMapping(value= "/saveproduct", method = RequestMethod.POST)
	public ModelAndView savebrand(@Valid @ModelAttribute("save_product")Product p,BindingResult result){
		ModelAndView mv =new ModelAndView("Product");
	   	System.out.println("in controller");
	   	//System.out.println("result" + result.hasErrors());
		/*if (result.hasErrors()) {
			 System.out.println("in error");
             return mv;
		 } else {*/
			
             String path = srv.getRealPath("/");
             String res = p.getFilePath(path, srv.getContextPath());
             System.out.println(res);
             if (res == "fail")
             {
                 return mv;
             }
             else {
            	System.out.println("testststs");
        		prod_srv.saveOrUpdate(p);
            	mv = new ModelAndView("index");
            	return mv;
             }
		//}
		
		}
	
	@RequestMapping(value="/editProduct/{id}")
	 public ModelAndView updateProduct(@PathVariable("id") int id){
		ModelAndView mv=new ModelAndView("Product") ;
		Product obj = prod_srv.getNameById(id);
		mv.addObject("productDetail", obj);
	    return mv;
	 }
	
	@RequestMapping(value="/delProduct/{id}")
	 public ModelAndView deleteProduct(@PathVariable("id") int id)
	  {
		   ModelAndView mv=new ModelAndView("Product");
		   prod_srv.delete(id);
		   List<Product> lsts = prod_srv.showProduct();
		   mv.addObject("ProductLists", lsts);
		   return mv;
	  }
	
}

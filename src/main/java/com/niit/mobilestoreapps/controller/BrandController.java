package com.niit.mobilestoreapps.controller;

import java.util.List;

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

import com.niit.mobilestoreapps.model.ProductBrand;
import com.niit.mobilestoreapps.service.BrandService;


@Controller
public class BrandController {

	@Autowired
	BrandService brndSrv;
	
	@RequestMapping(value = "/BrandOpt")
	public ModelAndView getBrandOperation(){
		ModelAndView mv=new ModelAndView("BrandOperation");
		List<ProductBrand> lsts = brndSrv.showBrand();
		mv.addObject("brands", lsts);
		return mv;
	}
	
	
	@RequestMapping(value="/addBrand",method=RequestMethod.GET)
	public ModelAndView getBrand()
	{
		ModelAndView mv=new ModelAndView("addBrand");
		mv.addObject(new ProductBrand());
		List<ProductBrand> lsts = brndSrv.showBrand();
		mv.addObject("brands", lsts);
		return mv;
	}
	
	
	@ModelAttribute("save_brand")
	public ProductBrand get_modelAttribute()
	{
		return new ProductBrand();
	}
	
	@RequestMapping(value= "/savebrand", method = RequestMethod.POST)
	public String savebrand(@Valid @ModelAttribute("save_brand")ProductBrand p,BindingResult result){
		if(result.hasErrors())
		{
			return "addBrand";
		}
		else
		{
			brndSrv.savebrand(p);
			return "index";
		}
		
	}
	
	 @RequestMapping(value="/editBrand/{id}")
	 public String edit_Brand(@PathVariable("id") int id, Model model){
	        model.addAttribute("brands", this.brndSrv.getNameById(id));
	        model.addAttribute("listbrand", this.brndSrv.showBrand());
	        return "addBrand";
	    }
		
	
}

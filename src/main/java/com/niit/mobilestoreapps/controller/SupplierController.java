package com.niit.mobilestoreapps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.mobilestoreapps.model.Supplier;

import com.niit.mobilestoreapps.service.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierService suppSrv;
	
	@RequestMapping(value= "/supplier")
	public ModelAndView getSupplier(){
		ModelAndView mv=new ModelAndView("supplier");
		List<Supplier> lsts = suppSrv.showSupplier();
		mv.addObject("suppliersList", lsts);
		return mv;
	}
	
	
	
	@ModelAttribute("save_supplier")
	public Supplier get_modelAttribute()
	{
		return new Supplier();
	}
	@RequestMapping(value= "/saveSupplier", method = RequestMethod.POST)
	public ModelAndView saveSupplier(@Valid @ModelAttribute("save_supplier")Supplier p,BindingResult result){
		ModelAndView mv;
		//System.out.println("in controller");
		System.out.println(p.getSupp_id());
		if(p.getSupp_id()==0)
		{
			suppSrv.saveSupplier(p);
		}
		else
		{
			suppSrv.updateSupplier(p);
		}
		mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value="/editSupplier/{id}")
	 public ModelAndView updateSupplier(@PathVariable("id") int id){
		ModelAndView mv=new ModelAndView("supplier") ;
		Supplier obj = suppSrv.getNameById(id);
		mv.addObject("supplierDetail", obj);
	    return mv;
	
	 }
	@RequestMapping(value="/delSupplier/{id}")
	   public ModelAndView deleteSupplier(@PathVariable("id") int id)
	   {
		   ModelAndView mv=new ModelAndView("supplier");
		   suppSrv.delete(id);
		   List<Supplier> lsts = suppSrv.showSupplier();
		   mv.addObject("suppliersList", lsts);
		   return mv;
	   }
}

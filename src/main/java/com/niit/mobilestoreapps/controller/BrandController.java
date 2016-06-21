package com.niit.mobilestoreapps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilestoreapps.model.ProductBrand;
import com.niit.mobilestoreapps.service.BrandService;
import com.niit.mobilestoreapps.service.BrandServiceImpl;

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
}

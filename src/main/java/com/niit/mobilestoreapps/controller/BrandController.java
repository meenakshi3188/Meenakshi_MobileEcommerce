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
import com.niit.mobilestoreapps.model.ProductBrand;
import com.niit.mobilestoreapps.service.BrandService;

@Controller
public class BrandController {

	@Autowired
	BrandService brndSrv;
	
	/*@RequestMapping(value = "/onLoad1",method=RequestMethod.GET)
	public ModelAndView listBrands(){
		ModelAndView mv=new ModelAndView("index");
		List<ProductBrand> lsts1 = brndSrv.showBrand();
		mv.addObject("brandsLst1", lsts1);
		return mv;
	}*/
	
	@RequestMapping(value = "/BrandOpt")
	public ModelAndView getBrandOperation(){
		ModelAndView mv=new ModelAndView("BrandOperation");
		//System.out.println("In controller");
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
	public ModelAndView savebrand(@Valid @ModelAttribute("save_brand")ProductBrand p,BindingResult result){
		ModelAndView mv;
		if(result.hasErrors())
		{
			mv = new ModelAndView("addBrand");
			List<ProductBrand> lsts = brndSrv.showBrand();
			mv.addObject("brands", lsts);
		}
		else
		{
			brndSrv.savebrand(p);
			mv = new ModelAndView("index");
		}
		return mv;
	}
   @RequestMapping(value="/editBrand/{id}")
	 public ModelAndView editBrand(@PathVariable("id") int id){
	   ModelAndView mv=new ModelAndView("editBrand");  
	   ProductBrand obj = brndSrv.getNameById(id);
	   mv.addObject("brands1", obj);
	   return mv;
	 }
   @RequestMapping(value = "/save", method = RequestMethod.POST)
   public ModelAndView saveupdatedBrand(@Valid @ModelAttribute("brands1") ProductBrand brands1,
		   BindingResult res) {
	   brndSrv.updateBrand(brands1);
       return new ModelAndView("index");
   }  
   @RequestMapping(value="/delBrand/{id}")
   public ModelAndView deleteBrand(@PathVariable("id") int id)
   {
	   //System.out.println(id);
	   ModelAndView mv=new ModelAndView("addBrand");
	   brndSrv.delete(id);
	   List<ProductBrand> lsts = brndSrv.showBrand();
		mv.addObject("brands", lsts);
	   return mv;
   }
}

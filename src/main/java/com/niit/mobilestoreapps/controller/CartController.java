package com.niit.mobilestoreapps.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.niit.mobilestoreapps.model.CartInfo;
import com.niit.mobilestoreapps.model.CartLineInfo;
import com.niit.mobilestoreapps.model.CustomerInfo;
import com.niit.mobilestoreapps.model.Product;
import com.niit.mobilestoreapps.model.ProductBrand;
import com.niit.mobilestoreapps.model.ProductInfo;

import com.niit.mobilestoreapps.model.Utils;
import com.niit.mobilestoreapps.service.BrandService;
import com.niit.mobilestoreapps.service.CartServiceImpl;
import com.niit.mobilestoreapps.service.OrderService;
import com.niit.mobilestoreapps.service.ProductService;
import com.niit.mobilestoreapps.service.UserService;

@Controller
public class CartController {
	
	@Autowired
	ProductService prod_srv;
	CartServiceImpl cart_srv;
	UserService user_srv;
	
	CartInfo cartInfo;
	
	@Autowired
	BrandService brndSrv;
	
	@Autowired
	private OrderService obj_OrderSrvImpl;

	@RequestMapping(value = "/cart")
	public ModelAndView addCart(HttpServletRequest request,@RequestParam("id") int id){
		ModelAndView mv=new ModelAndView("index");
		Principal principal = request.getUserPrincipal();
		HttpSession session = request.getSession();
		if(principal == null)
		{
			return new ModelAndView("redirect:/login");
		}
		else
		{
			Product p=prod_srv.getNameById(id);
			
			cartInfo = Utils.getCartInSession(request);
			ProductInfo productInfo = new ProductInfo(p);

			cartInfo.addProduct(productInfo, 1);
			
			session.setAttribute("total", cartInfo.getCartLines().size());

			List<CartLineInfo> lst = cartInfo.getCartLines();

			for (CartLineInfo obj : lst) {
				ProductInfo pri = obj.getProductInfo();
				System.out.println(pri.getCode() + " " + pri.getName());
			}

			mv.addObject("username", session.getAttribute("username"));
			mv = new ModelAndView("index");
			List<ProductBrand> lsts1 = brndSrv.showBrand();
			mv.addObject("brandsLst1", lsts1);
			List<Product> lst1=prod_srv.showProduct();
			mv.addObject("prdLst", lst1);
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/viewCart", method = RequestMethod.GET)
	public ModelAndView viewCart(HttpServletRequest request, Model model) {

		CartInfo myCart = Utils.getCartInSession(request);

		model.addAttribute("cartForm", myCart);

		return new ModelAndView("viewCart");
	}
	@RequestMapping(value = { "/viewCart" }, method = RequestMethod.POST)
	public String shoppingCartUpdateQty(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("cartForm") CartInfo cartForm) {

		CartInfo cartInfo = Utils.getCartInSession(request);
		cartInfo.updateQuantity(cartForm);

		// Redirect to shoppingCart page.
		return "redirect:/viewCart";
	}

	@RequestMapping({ "/shoppingCartRemoveProduct" })
	public String removeProductHandler(HttpServletRequest request, Model model, //
			@RequestParam(value = "code", defaultValue = "") int code) {
		Product product = prod_srv.getNameById(code);
		if (product != null) {
			CartInfo cartInfo = Utils.getCartInSession(request);
			ProductInfo productInfo = new ProductInfo(product);
			cartInfo.removeProduct(productInfo);
		}
		// Redirect to shoppingCart page.
		return "redirect:/viewCart";
	}
	@RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.GET)
	public String shoppingCartCustomerForm(HttpServletRequest request, Model model) 
	{
		CartInfo cartInfo = Utils.getCartInSession(request);
		if (cartInfo.isEmpty()) {
			return "redirect:/viewCart";
		}

		CustomerInfo customerInfo = cartInfo.getCustomerInfo();
		System.out.println(customerInfo);
		if (customerInfo == null) {
			customerInfo = new CustomerInfo();
		}

		model.addAttribute("customerForm", customerInfo);

		return "shoppingCartCustomer";
	}

	@RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.POST)
	public String shoppingCartCustomerSave(HttpServletRequest request, Model model, //
			@ModelAttribute("customerForm") @Validated CustomerInfo customerForm, BindingResult result) 
	{
		if (result.hasErrors()) 
		{
			customerForm.setValid(false);
			return "shoppingCartCustomer";
		}

		customerForm.setValid(true);
		CartInfo cartInfo = Utils.getCartInSession(request);

		cartInfo.setCustomerInfo(customerForm);

		return "shoppingCartConfirmation";
	}
	
	// GET: Review Cart to confirm.
    @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.GET)
    public String shoppingCartConfirmationReview(HttpServletRequest request, Model model) {
        CartInfo cartInfo = Utils.getCartInSession(request);
 
        // Cart have no products.
        if (cartInfo.isEmpty()) {
            // Redirect to shoppingCart page.
            return "redirect:/shoppingCart";
        } else if (!cartInfo.isValidCustomer()) {
            // Enter customer info.
            return "redirect:/shoppingCartCustomer";
        }
 
        return "shoppingCartConfirmation";
    }
    
 // POST: Send Cart (Save).
    @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.POST)
    public String shoppingCartConfirmationSave(HttpServletRequest request, Model model) {
        CartInfo cartInfo = Utils.getCartInSession(request);
 
        if (cartInfo.isEmpty()) {
            return "redirect:/viewCart";
        } else if (!cartInfo.isValidCustomer()) {
            return "redirect:/shoppingCartCustomer";
        }
        try {
        	obj_OrderSrvImpl.saveOrder(cartInfo);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            return "shoppingCartConfirmation";
        }
        Utils.removeCartInSession(request);
        Utils.storeLastOrderedCartInSession(request, cartInfo);
        return "redirect:/shoppingCartFinalize";
    }
    
    @RequestMapping(value = { "/shoppingCartFinalize" }, method = RequestMethod.GET)
    public String shoppingCartFinalize(HttpServletRequest request, Model model) {
 
        CartInfo lastOrderedCart = Utils.getLastOrderedCartInSession(request);
 
        if (lastOrderedCart == null) {
            return "redirect:/viewCart";
        }
 
        return "shoppingCartFinalize";
    }

}

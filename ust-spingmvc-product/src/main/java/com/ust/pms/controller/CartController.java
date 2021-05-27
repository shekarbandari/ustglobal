package com.ust.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.model.Cart;
import com.ust.pms.model.Product;
import com.ust.pms.service.CartService;
import com.ust.pms.service.ProductService;
import com.ust.pms.util.UserUtil;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;



	@RequestMapping("/cartList")
	public ModelAndView checkProductList(Model model, Product products) {

		model.addAttribute("username", UserUtil.getUserName());
		model.addAttribute("command", products);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("cart");

		if(products.getProductId()!=0) {
		Product product = productService.getProduct(products.getProductId());
		Cart cart = new Cart();
		cart.setProductId(product.getProductId());
		cart.setProductName(product.getProductName());
		cart.setPrice(product.getPrice());
		cart.setQuantityOnHand(product.getQuantityOnHand());

		cartService.saveCart(cart);

		productService.deleteProductById(products.getProductId());
		}
		//

		List<Cart> cartList = cartService.getCartDetails();
		mav.addObject("cartList", cartList);

		return mav;

	}

	@RequestMapping("/deleteCart/{productId}")
	public String deleteCart(@PathVariable("productId") int productId, Model model) {
			
		Cart cart = cartService.getCart(productId);
		
		
		  Product product=new Product(); 
		  product.setProductId(cart.getProductId());
		  product.setProductName(cart.getProductName());
		  product.setQuantityOnHand(cart.getQuantityOnHand());
		  product.setPrice(cart.getPrice()); productService.saveProduct(product);
		 
		
		
		
		cartService.deleteCart(cart);
		
		
		
		return "redirect:/cartList";
	}

}

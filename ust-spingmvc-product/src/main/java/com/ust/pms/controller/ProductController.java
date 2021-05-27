package com.ust.pms.controller;

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

import com.ust.pms.model.Cart;
import com.ust.pms.model.Product;
import com.ust.pms.service.CartService;
import com.ust.pms.service.ProductService;
import com.ust.pms.util.UserUtil;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	CartService cartService;

	@RequestMapping(value = "/product")
	public ModelAndView productHome(Model model) {
		
		model.addAttribute("username", UserUtil.getUserName());

		return new ModelAndView("productHome", "command", new Product());
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("command")Product product, Model model,BindingResult result) {

		if(result.hasErrors()) {
			model.addAttribute("command",new Product());
			return "productHome";
		}else {
		if(productService.isProductExist(product.getProductId()) || cartService.isCartExist(product.getProductId())) {
			model.addAttribute("command",new Product());
			model.addAttribute("alreadyExistProduct","Product Id already available , Please give another Product Id");
			return "productHome";
		}else {
		
		productService.saveProduct(product);
		return "redirect:productList";
		}
		}
	}
	
	

	@RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable("productId") int productId, Model model) {
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);

		return "updateProduct";
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product, Model model) {

		productService.updateProduct(product);
		return "redirect:productList";
	}

	@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable("productId") int productId, Model model) {
		Product product = productService.getProduct(productId);

		productService.deleteProduct(product);

		return "redirect:/productList";
	}

	
	@RequestMapping("/productList")
	public String getProductDetails(Model model, @ModelAttribute("command") Product product) {

		model.addAttribute("username", UserUtil.getUserName());

		List<Product> products = productService.getProductDetails();
		model.addAttribute("products", products);
		model.addAttribute("cart", new Cart());
		return "productList";
	}

	@RequestMapping("/searchProductByIdForm")
	public ModelAndView searchProductById() {
		return new ModelAndView("searchProductByIdForm", "command", new Product());

	}

	@RequestMapping("/searchProductById")
	public ModelAndView searchProductById(Product product) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchProductByIdForm");

		int productId = product.getProductId();

		if (productService.isProductExist(productId)) {
			Product productDetails = productService.getProduct(product.getProductId());
			mav.addObject("command", productDetails);

		} else {
			mav.addObject("command", new Product());
			mav.addObject("message", "Product with product id :" + productId + " doesn't exist");

		}
		return mav;

	}

	@RequestMapping("/deleteProductById")
	public ModelAndView deleteProductById(Product product) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchProductByIdForm");
		mav.addObject("command", new Product());
		int productId = product.getProductId();

		if (productService.isProductExist(productId)) {
			productService.deleteProductById(productId);
			mav.addObject("message", "product with product id" + productId + " deleted successfully");

		} else {

			mav.addObject("message", "Product with product id :" + productId + " doesn't exist");
			// return new ModelAndView("searchProductByIdForm","command",new Product());

		}
		return mav;

	}

}

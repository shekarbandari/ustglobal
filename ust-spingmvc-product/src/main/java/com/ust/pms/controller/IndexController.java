package com.ust.pms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.model.Product;
import com.ust.pms.model.UserRegistration;
import com.ust.pms.util.UserUtil;

@Controller
public class IndexController {

	

	@RequestMapping("/")
	public String welcome(Model model) {

		model.addAttribute("username", UserUtil.getUserName());

		model.addAttribute("command", new Product());

		return "redirect:productList";
	}

	

	@RequestMapping("/index")
	public ModelAndView index(Model model) {

		model.addAttribute("username", UserUtil.getUserName());
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", "shekarb");
		mav.addObject("password", "shekar@1234");
		mav.setViewName("successCustomer");

		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("errorMsg", "User name or Password are incorrect !!!");
		}
		if (logout != null) {
			model.addAttribute("logoutMsg", "User logged out successfully!!!");
		}
		return "login";
	}
	

	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("registration", "user", new UserRegistration());
	}

	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;

	@PostMapping("/register")
	public ModelAndView registerUser(@Valid @ModelAttribute("user") UserRegistration userRegistration,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("registration");
		} else {
			if (userRegistration.getPassword().equals(userRegistration.getConfirmPassword())) {

				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				
				
				if(userRegistration.getRole().equals("USER"))
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				
				if(userRegistration.getRole().equals("ADMIN"))
					authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				
				

				User user = new User(userRegistration.getUsername(), userRegistration.getPassword(), authorities);

				jdbcUserDetailsManager.createUser(user);

				return new ModelAndView("login", "registrationMessage",
						"U have been successfully registered , please login to proceed");
			} else {
				return new ModelAndView("registration", "failedRegistrationMessage",
						"Please check !!!! New password and Confirm password are not equals");
			}
		}
	}

}

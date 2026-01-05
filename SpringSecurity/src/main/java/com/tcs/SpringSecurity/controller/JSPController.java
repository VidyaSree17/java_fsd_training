package com.tcs.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.SpringSecurity.bean.User;
import com.tcs.SpringSecurity.service.UserService;

@Controller
public class JSPController {
	
	@Autowired
	private UserService service;

	@RequestMapping("/sam")
	public String getJSPPage() {
		return "sample";
	}
	
	@RequestMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping("/wel")
	public String getWelcomePage() {
		return "welcome";
	}
	
	@RequestMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String getRegisterData(@ModelAttribute("user") User user, Model model) {
		BcryptPassword4jPasswordEncoder b= new BcryptPassword4jPasswordEncoder();
		String encodedPassword=b.encode(user.getPassword());
		user.setPassword(encodedPassword);
		service.saveUser(user);
		return "welcome";
	}
}

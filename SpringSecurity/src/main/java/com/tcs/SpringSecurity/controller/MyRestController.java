package com.tcs.SpringSecurity.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@GetMapping("/getmsg")
	public String getMsg(String msg) {
		return "Welcome to the page";
	}
	
	public static void main(String[] args) {
		PasswordEncoder p=new BcryptPassword4jPasswordEncoder();
		String password="xyz123";
		String encryptedPassword=p.encode(password);
		System.out.println(encryptedPassword);
	}
}

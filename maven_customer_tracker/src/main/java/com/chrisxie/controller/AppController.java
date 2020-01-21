package com.chrisxie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chrisxie.entity.Customer;
import com.chrisxie.entity.Users;
import com.chrisxie.service.ServiceLayer;

@Controller

public class AppController {

	@Autowired
	private ServiceLayer serviceLayer;
	
	
	
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		
		
		
		return "login-page";
	}
	
	
	@GetMapping("/accessDenied")
	public String showAccessDeniedPage() {
		
		return "access-denied-page";
		
	}
	
	
	@GetMapping("/signup")
	public String showSignupForm(Model model) {
		
		Users userToSave = new Users();
		
		model.addAttribute("newUser", userToSave);
		
		return "signup-page";
		
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("newUser")Users userToSave) {
		
		serviceLayer.saveUser(userToSave);
		
		
		return "create-successful-page";
		
	}
	
	
}

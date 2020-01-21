package com.chrisxie.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chrisxie.entity.Users;
import com.chrisxie.service.ServiceLayer;

@Controller
@RequestMapping("/admin")
public class AdminController {

		@Autowired
		private ServiceLayer serviceLayer;
	

	@GetMapping("/manage")
	public String showAdminPage(Model model) {
		
		List<Users> userList = new LinkedList<>();
		
		userList = serviceLayer.getUserList();
		
		model.addAttribute("userList", userList);
		
		
		return "admin-page";
		
	}
	
	
	
	
	
}

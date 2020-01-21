package com.chrisxie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chrisxie.dao.CustomerDAO;
import com.chrisxie.entity.Customer;
import com.chrisxie.service.ServiceLayer;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	
	@Autowired
	private ServiceLayer serviceLayer;
	
	
	@GetMapping("/updateCustomer")
	public String showUpdateForm(@RequestParam("customerId") int id, Model model) {
		
		Customer customerToUpdate = serviceLayer.getCustomerById(id);
		
		
		model.addAttribute("newCustomer", customerToUpdate);
		
		
		return "add-customer-page";
	}
	
	
	@GetMapping("/deleteCustomer")
	public String showDeleteCustomerDialog(@RequestParam("customerId")int id, Model model) {
		
		serviceLayer.deleteCustomerById(id);
			
		return "redirect:/home";
		
	}
	
	
}

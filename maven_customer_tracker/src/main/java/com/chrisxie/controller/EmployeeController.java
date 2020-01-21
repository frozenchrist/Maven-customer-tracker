package com.chrisxie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chrisxie.entity.Customer;
import com.chrisxie.service.ServiceLayer;

@Controller
@RequestMapping("/home")
public class EmployeeController {

	@Autowired
	private ServiceLayer serviceLayer;
	
	
	@GetMapping("")
	public String showHomePage(Model model) {
		
		List<Customer>customerList = serviceLayer.getCustomerList();
		
		model.addAttribute("customerList", customerList);
		
		return "home-page";
	}
	
	
	@GetMapping("/addForm")
	public String showAddCustomerFrom(Model model) {
		
		Customer customerToAdd = new Customer();
		
		model.addAttribute("newCustomer", customerToAdd);
		
		return "add-customer-page";
		
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("newCustomer") Customer customerToAdd) {
		
		serviceLayer.saveCustomer(customerToAdd);
		
		
		return "redirect:/home";
	}
	
	
	@GetMapping("/search")
	public String showSearchResult(@RequestParam("searchName")String searchName, Model model) {
		
		if (searchName.trim().length() < 1 || searchName == null) {
			
			return "redirect:/home";
			
		}
		
		List<Customer> searchResult = serviceLayer.getSearchResult(searchName);
		
		model.addAttribute("customerList", searchResult);
		
		return "home-page";
	}
	
	
}

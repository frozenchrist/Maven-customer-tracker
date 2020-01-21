package com.chrisxie.service;

import java.util.List;

import com.chrisxie.entity.Customer;
import com.chrisxie.entity.Users;

public interface ServiceLayer {

	
	public List<Customer> getCustomerList();
	
	public List<Users> getUserList();
	
	public void saveCustomer(Customer customerToSave);
	
	public void saveUser(Users userToSave);
	
	public Customer getCustomerById(int id);
	
	public void deleteCustomerById(int id);
	
	public List<Customer> getSearchResult(String searchName);
	
}

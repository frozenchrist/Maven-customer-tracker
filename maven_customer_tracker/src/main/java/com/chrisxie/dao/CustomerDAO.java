package com.chrisxie.dao;

import java.util.List;

import com.chrisxie.entity.Customer;

public interface CustomerDAO {

	
	public List<Customer> getCustomerList();
	
	public void saveCustomer(Customer customerToSave);
	
	public Customer getCustomerById(int id);

	public void deleteCustomerById(int id);
	
	public List<Customer> getSearchResult(String searchName);
	
}

package com.chrisxie.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.chrisxie.dao.CustomerDAO;
import com.chrisxie.dao.UserDAO;
import com.chrisxie.entity.Customer;
import com.chrisxie.entity.Users;

@Service
public class ServiceLayerImp implements ServiceLayer {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomerList() {

		return customerDAO.getCustomerList();
		
		
	}

	@Override
	@Transactional
	public List<Users> getUserList() {
		// TODO Auto-generated method stub
		return userDAO.getUserList();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customerToSave) {
		// TODO Auto-generated method stub
		
		customerDAO.saveCustomer( customerToSave);
		
	}

	@Override
	@Transactional
	public void saveUser(Users userToSave) {

		userDAO.saveUser(userToSave);
		
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {

		return customerDAO.getCustomerById(id);
		
	}

	@Override
	@Transactional
	public void deleteCustomerById(int id) {

		customerDAO.deleteCustomerById(id);
		
	}

	@Override
	@Transactional
	public List<Customer> getSearchResult(String searchName) {
		
		return customerDAO.getSearchResult(searchName);
	}
	
	
	
	

}

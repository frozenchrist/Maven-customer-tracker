package com.chrisxie.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chrisxie.entity.Customer;



@Repository
public class CustomerDAOImp implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	public List<Customer> getCustomerList() {

		Session session = sessionFactory.getCurrentSession();
		
		List<Customer> customerList = new LinkedList<>();
		
		customerList = session.createQuery("from Customer order by lastName").getResultList(); 
		
		return customerList;
	}

	@Override
	public void saveCustomer(Customer customerToSave) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customerToSave);
		
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomerById(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		session.delete(getCustomerById(id));
		
	}

	@Override
	public List<Customer> getSearchResult(String searchName) {

		Session session = sessionFactory.getCurrentSession();
		
		Query searchNameQuery = session.createQuery("from Customer where lower(firstName) like :searchName or lower(lastName) like :searchName or lower(email) like :searchName");
		
		searchNameQuery.setParameter("searchName", "%" + searchName + "%");
		
		return searchNameQuery.getResultList();
	}

}

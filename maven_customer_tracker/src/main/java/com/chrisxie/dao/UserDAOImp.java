package com.chrisxie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chrisxie.entity.Users;


@Repository
public class UserDAOImp implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Users> getUserList() {

		Session session = sessionFactory.getCurrentSession();
		
		
		
		return session.createQuery("from Users order by username").getResultList();
	}

	@Override
	public void saveUser(Users userToSave) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(userToSave);
		
	}

}

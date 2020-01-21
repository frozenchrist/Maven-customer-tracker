package com.chrisxie.dao;

import java.util.List;

import com.chrisxie.entity.Users;

public interface UserDAO {

	public List<Users> getUserList();
	
	public void saveUser(Users userToSave);
	
}

package com.chrisxie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")

public class Users {
	
	@Id
	@Column(name = "username")
	@NotNull
	private String username;
	
	
	@Column(name = "password")
	private String password;
	
	
	@Column(name = "enabled")
	private int enabled;
	
	public Users() {
		// TODO Auto-generated constructor stub
		
		enabled = 1;
	}

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		enabled = 1;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
	
	
	
}

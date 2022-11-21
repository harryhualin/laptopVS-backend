package com.mercury.laptapVS.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.laptapVS.bean.User;

public interface UserDao extends JpaRepository<User,Integer> {

	public User findByUsername(String name);

	

	
}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.CrudInHash;
import com.example.demo.entity.User;

@Service
public class UserService {

	@Autowired
	private CrudInHash ch;
	
	public String save(User user) {
		return ch.save(user);
	}
	
	public User displayInfo(String email) {
		return ch.DisplayInfo(email);
	}
	
	public String update(User user) {
		return ch.update(user);
	}
	
	public String delete(User user) {
		return ch.delete(user);
	}
}

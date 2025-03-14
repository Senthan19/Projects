package com.example.demo.database;

import java.util.*;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class CrudInHash {
	
	static Map<String, Map<String, Object>> details = new HashMap<>();
	
	// register for user 
	public String save(User user) {
		if (user != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", user.getId());
			map.put("name", user.getName());
			map.put("email", user.getEmail());
			map.put("age", user.getAge());
			
			details.put(user.getEmail(), map);
			return "User Registration Successfull";
		} else {
			return null;
		}
	}
	
	// login method by use of email
	public User DisplayInfo(String email) {
		if (details.containsKey(email)) {
			Map<String, Object> temp = details.get(email);
			User user = new User((String)temp.get("id"), (String)temp.get("name"), (String)temp.get("email"), (Integer)temp.get("age"));
			return user;
		}
		return null;
	}
	
	// update the user credentials
	public String update(User user) {
		String temp = save(user);
		if(details.containsKey(user.getEmail())) {
			return "Updated successfully!";
		} else {
			return temp; 
		}
	}
	
	// delete the user credentials
	public String delete(User user) {
		if(details.containsKey(user.getEmail())) {
			details.remove(user.getEmail());
			return "User has been deleted Successfully";
		} else {
			return null;
		}
	}
}

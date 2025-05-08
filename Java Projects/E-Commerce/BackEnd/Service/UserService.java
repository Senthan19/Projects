package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Users;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public Users registerUser(Users user) {
		if(user != null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		}
		return null; 
	}
	
	public Users updateUser(Users user) {
		Users temp = userRepository.findById(user.getId()).orElse(null);
		if(!temp.getUsername().equals(user.getUsername()) && !temp.getEmailId().equals(user.getEmailId())) {
			temp.setUsername(user.getUsername());
			temp.setEmailId(user.getEmailId());
			return userRepository.save(temp);
		} else if(!temp.getUsername().equals(user.getUsername())){
			temp.setUsername(user.getUsername());
			return userRepository.save(temp);
		} else if (!temp.getEmailId().equals(user.getEmailId())){
			temp.setEmailId(user.getEmailId());
			return userRepository.save(temp);
		}
		return null;
	}
	
	public String deleteUser(Integer id) {
		Users user = userRepository.getById(id);
		if(user != null) {
			userRepository.deleteById(id);
			return "Deleted Successfully";
		}
		return "There is no User found";
	}
	public Users loginUser(String username, String password) {
		Users user = userRepository.getByUsername(username);
		if(user != null && passwordEncoder.matches(password, user.getPassword())) {
			return user;
		}
		return null;
	}
}

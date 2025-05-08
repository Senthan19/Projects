package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Users;
import com.example.demo.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	

	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody Users user) {
		return ResponseEntity.ok(userService.registerUser(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
		return ResponseEntity.ok(userService.loginUser(credentials.get("username"), credentials.get("password")));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(userService.deleteUser(id));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody Users user) {
		return ResponseEntity.ok(userService.updateUser(user));
	}
}

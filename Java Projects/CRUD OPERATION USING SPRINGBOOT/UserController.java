package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		String result = userService.save(user);
		if (result != null) {
		return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check the User Inputs Once");
		}
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam("email") String email) {
		User user = userService.displayInfo(email);
		if (user != null) {
			return ResponseEntity.ok("Welcome " + user.getName() + "\n" + user);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not found");
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody User user) {
		String report = userService.update(user);
		if(user != null) {
			return ResponseEntity.ok(report);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check the User Inputs Once");
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody User user) {
		String report = user + " " + userService.delete(user);
		if (report != null) {
			return ResponseEntity.ok(report);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not found");
		}
	}
}

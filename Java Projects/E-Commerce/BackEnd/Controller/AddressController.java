package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Users;
import com.example.demo.Service.AddressService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService as;
	
	@PostMapping("/add")
	public ResponseEntity<?> registerUser(@RequestBody Address a) {
		return ResponseEntity.ok(as.addAddress(a));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody Address a) {
		return ResponseEntity.ok(as.upadateAddress(a));
	}
}

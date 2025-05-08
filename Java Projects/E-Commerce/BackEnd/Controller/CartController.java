package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cart;
import com.example.demo.Service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/create")
	public ResponseEntity<?> addTask(@RequestBody Cart cart) {
		Cart temp = cartService.addCart(cart);
		return ResponseEntity.ok(temp);
	}
}

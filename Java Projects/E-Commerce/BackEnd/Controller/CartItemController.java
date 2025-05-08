package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.CartItems;
import com.example.demo.Service.CartItemsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cartItems")
public class CartItemController {

	@Autowired
	private CartItemsService cartItemService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addItem(@RequestBody CartItems c) {
		return ResponseEntity.ok(cartItemService.addItems(c));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getItems(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(cartItemService.getProducts(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(cartItemService.deleteItem(id));
	}
	
}

package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Products;
import com.example.demo.Service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertProduct(@RequestBody Products product) {
		return ResponseEntity.ok(productService.insertProduct(product));
	}
	
	@GetMapping("/All Products")
	public ResponseEntity<?> getAllProducts() {
		List<Products> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/byCategoryName/{name}")
	public ResponseEntity<?> getByCategoryName(@PathVariable("name") String name) {
		return ResponseEntity.ok(productService.getByCategoryName(name));
	}
}

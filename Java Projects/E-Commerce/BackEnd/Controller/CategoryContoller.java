package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Category;
import com.example.demo.Service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryContoller {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/addcategory")
	public ResponseEntity<?> addCategory(@RequestBody Category cateogory) {
		return ResponseEntity.ok(categoryService.addCategory(cateogory));
	}
}

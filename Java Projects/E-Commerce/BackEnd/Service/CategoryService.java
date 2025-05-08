package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public String addCategory(Category category) {
		if(category != null) {
			categoryRepository.save(category);
			return "Added Successfully";
		}
		return "there is something missing in credentials";
	}
	
	
}

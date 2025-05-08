package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Products;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public String insertProduct(Products product) {
		if(product != null) {
			productRepository.save(product);
			return "Product Inserted Successfully";
		}
		return "there is something missing in credentials";
	}
	
	public List<Products> getAllProducts() {
		return productRepository.findAll();
	}
	
	public List<Products> getProductsByCategoryId(Integer id) {
		return productRepository.findByCategoryId(id);
	}
	
	public List<Products> getByCategoryName(String name) {
	    if (name.equals("all")) {
	        // If category is not selected, return all products
	        return getAllProducts();
	    }
	    return productRepository.findByCategoryName(name);
	}

}

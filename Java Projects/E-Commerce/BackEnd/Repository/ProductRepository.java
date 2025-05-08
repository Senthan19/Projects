package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer>{
	List<Products> findByCategoryId(Integer id);
	List<Products> findByCategoryName(String name);
}

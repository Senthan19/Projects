package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	Cart findByUserId(Integer id);
}

package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Integer>{
	List<CartItems> findByCartId(Integer id);
	  CartItems findByCartIdAndProductId(Integer cartId, Integer productId);
}

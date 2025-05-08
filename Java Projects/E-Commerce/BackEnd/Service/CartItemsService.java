package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.CartItems;
import com.example.demo.Entity.Products;
import com.example.demo.Repository.CartItemsRepository;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.ProductRepository;

@Service
public class CartItemsService {

	@Autowired
	private CartItemsRepository cartItemsRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	

	public String addItems(CartItems cartItem) {
	    Cart cart = cartRepository.findById(cartItem.getCart().getId()).orElse(null);
	    Products product = productRepository.findById(cartItem.getProduct().getId()).orElse(null);

	    if (cart != null && product != null) {
	        CartItems existingItem = cartItemsRepository.findByCartIdAndProductId(
	            cartItem.getCart().getId(), 
	            cartItem.getProduct().getId()
	        );

	        if (existingItem != null) {
	            existingItem.setQuantity(existingItem.getQuantity() + 1);
	            cartItemsRepository.save(existingItem);
	            return "One More Quantity of That Product Added";
	        } else {
	            cartItemsRepository.save(cartItem);
	            return "Product Added";
	        }
	    }

	    return "Something Missing";
	}

	
	public String removeItems(Integer id) {
		cartItemsRepository.deleteById(id);
		return "Delete the product";
	}
	
	public List<CartItems> getProducts(Integer id) {
		List<CartItems> items = cartItemsRepository.findByCartId(id);
		return items;
	}
	
	public String deleteItem(Integer id) {
		cartItemsRepository.deleteById(id);
		return "Deleted";
	}
}

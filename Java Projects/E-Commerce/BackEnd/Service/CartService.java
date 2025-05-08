package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Cart addCart(Cart cart) {
		Users user = userRepository.findById(cart.getUser().getId()).orElse(null);
		Cart temp = cartRepository.findByUserId(cart.getUser().getId());
		if(temp == null && user != null) {
			cart.setUser(user);
			return cartRepository.save(cart);
		}
		return temp;
	}
}

package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products product;
	
	@Column(name = "quantity")
	private Integer quantity;

	public CartItems(Integer id, Cart cart, Products product, Integer quantity) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public CartItems(Cart cart, Products product, Integer quantity) {
		super();
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public CartItems() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}

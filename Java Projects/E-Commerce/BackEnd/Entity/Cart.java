package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;

	public Cart(Integer id, Users user) {
		super();
		this.id = id;
		this.user = user;
	}

	public Cart(Users user) {
		super();
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Cart() {
		super();
	}
	
	
}

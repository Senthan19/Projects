package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ordertable")
public class OrderTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;

	public OrderTable(Integer id, Users user) {
		super();
		this.id = id;
		this.user = user;
	}

	public OrderTable(Users user) {
		super();
		this.user = user;
	}

	public OrderTable() {
		super();
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
	
	
}

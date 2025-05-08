package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		super();
	}
	
	
}

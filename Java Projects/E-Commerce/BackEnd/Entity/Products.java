package com.example.demo.Entity;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "created_at", updatable = false, insertable = false)
	private Timestamp created_at;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Products(Integer id, String name, String description, double price, String imageUrl, int stock,
			Timestamp created_at, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.stock = stock;
		this.created_at = created_at;
		this.category = category;
	}

	public Products(String name, String description, double price, String imageUrl, int stock, Timestamp created_at,
			Category category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.stock = stock;
		this.created_at = created_at;
		this.category = category;
	}

	public Products() {
		super();
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}

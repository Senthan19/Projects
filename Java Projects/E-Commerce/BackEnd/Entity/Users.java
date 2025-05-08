package com.example.demo.Entity;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String username;
	
	@Column(name = "email")
	private String emailId;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "role")
	private String role;
	
    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp created_at;

	public Users(int id, String username, String emailId, String password, String role, Timestamp created_at) {
		super();
		this.id = id;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.created_at = created_at;
	}

	public Users(String username, String emailId, String password, String role, Timestamp created_at) {
		super();
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.created_at = created_at;
	}

	public Users() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
    
    
}

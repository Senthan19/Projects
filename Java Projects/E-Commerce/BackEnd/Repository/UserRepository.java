package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	void deleteById(Integer userId);
	Users getByUsername(String userName);
	Users findByEmailId(String emailId);
}

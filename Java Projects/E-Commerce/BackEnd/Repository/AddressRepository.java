package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{
		Address findByUserId(Integer id);
}

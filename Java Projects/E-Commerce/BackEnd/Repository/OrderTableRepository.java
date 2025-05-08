package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.OrderTable;

@Repository
public interface OrderTableRepository extends JpaRepository<OrderTable,Integer>{
	OrderTable findByUserId(Integer id);
}

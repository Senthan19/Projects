package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{
	List<OrderItem> findByOrderTableId(Integer id);
}

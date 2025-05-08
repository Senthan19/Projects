package com.example.demo.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.OrderTable;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.OrderTableRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class OrderTableService {

	@Autowired
	private OrderTableRepository otr;
	@Autowired
	private UserRepository ur;
	
	public OrderTable createOrderTable(Map<String,Integer> user) {
		OrderTable ot = otr.findByUserId(user.get("id"));
		if(ot != null) {
			return ot;
		}
		Users temp = ur.findById(user.get("id")).orElse(null);
		ot = new OrderTable();
		ot.setUser(temp);
		return otr.save(ot);
	}
}

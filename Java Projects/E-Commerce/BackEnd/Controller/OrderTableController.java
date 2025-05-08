package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.OrderTableService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/ordertable")
public class OrderTableController {

	@Autowired
	private OrderTableService ots;
	
	@PostMapping("/create")
	public ResponseEntity<?> createOrderTable(@RequestBody Map<String,Integer> temp) {
		return ResponseEntity.ok(ots.createOrderTable(temp));
	}
}

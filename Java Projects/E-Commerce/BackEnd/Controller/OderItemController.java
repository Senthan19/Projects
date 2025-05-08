package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.OrderItem;
import com.example.demo.Service.OrderItemsService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/order-items")
public class OderItemController {

    @Autowired
    private OrderItemsService orderItemService;

    @PostMapping("/create")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItem);
        return new ResponseEntity<>(createdOrderItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderItem>> getAllOrderItems(@PathVariable int id) {
        List<OrderItem> orderItems = orderItemService.getAllOrders(id);
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }

   

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable int id) {
        orderItemService.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }
}

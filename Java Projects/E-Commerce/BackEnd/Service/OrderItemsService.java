package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.OrderItem;
import com.example.demo.Entity.OrderTable;
import com.example.demo.Entity.Products;
import com.example.demo.Repository.OrderItemRepository;
import com.example.demo.Repository.OrderTableRepository;
import com.example.demo.Repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderTableRepository orderTableRepository;

    public OrderItem createOrderItem(OrderItem orderItem) {
    	Products product = productRepository.findById(orderItem.getProduct().getId()).orElse(null);
    	OrderTable ot = orderTableRepository.findById(orderItem.getOrderTable().getId()).orElse(null);
    	if(product != null && ot != null) {
    		orderItem.setProduct(product);
    		orderItem.setOrderTable(ot);
    		orderItem.setStartDate(LocalDateTime.now());
    		orderItemRepository.save(orderItem);
    	}
    	return null;
    
    }
   public String cancelOrder(Integer id) {
	   orderItemRepository.deleteById(id);
	   return "Deleted";
   }

 public List<OrderItem> getAllOrders(Integer id) {
	 return  orderItemRepository.findByOrderTableId(id);
 }
    // You can create other necessary methods for your business logic here.
}


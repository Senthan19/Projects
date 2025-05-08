package com.example.demo.Entity;



import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;  // assuming you have a Product entity

    @ManyToOne
    @JoinColumn(name = "ordertable_id", referencedColumnName = "id")
    private OrderTable orderTable;  // assuming you have an OrderTable entity

    private String address;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @PrePersist
    public void setEndDate() {
        if (startDate != null) {
            this.endDate = startDate.plusDays(5);  // Set end_date 5 days after start_date
        }
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}


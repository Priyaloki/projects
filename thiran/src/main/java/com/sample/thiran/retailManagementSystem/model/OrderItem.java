package com.sample.thiran.retailManagementSystem.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderItem {
    private String productId;
    private Integer quantity;

    // Default no-argument constructor
    public OrderItem(){

    }

    public OrderItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
}

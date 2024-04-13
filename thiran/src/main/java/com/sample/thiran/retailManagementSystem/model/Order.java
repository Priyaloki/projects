package com.sample.thiran.retailManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "orders")
public class Order {
    @Id
    public String orderId;
    @ElementCollection
    public List<OrderItem> items;
    public OrderStatus status;
    public String trackingNumber;
    public String recipientName;
    public String shippingAddress;
    public String shippingCity;
    public String shippingState;
    public String shippingZipCode;
    public Double packageWeight;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }
    
}

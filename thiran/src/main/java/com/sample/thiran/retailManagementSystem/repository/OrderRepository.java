package com.sample.thiran.retailManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.thiran.retailManagementSystem.model.Order;


public interface OrderRepository extends JpaRepository<Order, String>{
    
}

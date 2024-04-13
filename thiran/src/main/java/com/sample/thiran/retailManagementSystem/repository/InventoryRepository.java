package com.sample.thiran.retailManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.thiran.retailManagementSystem.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String>{

    Inventory findByProductId(String productId);
} 

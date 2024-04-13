package com.sample.thiran.retailManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.thiran.retailManagementSystem.model.Clothing;

public interface ClothingRepository extends JpaRepository<Clothing, String>{
    
}

package com.sample.thiran.retailManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.thiran.retailManagementSystem.model.Electronics;

public interface ElectronicsRepository extends JpaRepository<Electronics, String>{
    
}

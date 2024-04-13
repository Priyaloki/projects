package com.sample.thiran.retailManagementSystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.thiran.retailManagementSystem.model.Inventory;
import com.sample.thiran.retailManagementSystem.repository.InventoryRepository;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;


    public String saveInventoryDetails(String productId,Integer quantity){
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if(inventory != null){
            inventory.quantity = quantity;
        }else{
            inventory = new Inventory(productId, quantity);
        }
        
        inventoryRepository.save(inventory);
        
        return "inventory details added successfully ";
    }

    public int getAvailableQuantity(String productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if(inventory != null){
            return inventory.getQuantity();
        }else {
            return 0; // Return 0 if product not found in inventory
        }
    }

    
}

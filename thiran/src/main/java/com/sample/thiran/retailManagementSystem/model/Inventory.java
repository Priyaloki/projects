package com.sample.thiran.retailManagementSystem.model; 

import com.sample.thiran.retailManagementSystem.commons.UniqueIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory{

    @Id
    public String inventoryId;
    public String productId;
    public Integer quantity;

    public Inventory(){

    }

    public Inventory(String productId, Integer quantity){
        this.productId = productId;
        this.inventoryId = UniqueIdGenerator.generateUniqueId(10);
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
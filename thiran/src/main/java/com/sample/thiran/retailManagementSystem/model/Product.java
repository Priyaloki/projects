package com.sample.thiran.retailManagementSystem.model;

import com.sample.thiran.retailManagementSystem.commons.UniqueIdGenerator;
import com.sample.thiran.retailManagementSystem.payload.ProductUpsertReq;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
public class Product {
    @Id
    public String productId;
    public String productName;
    public double price;

    public Product() {
        // Default constructor required by JPA
    }

    public Product(ProductUpsertReq productCreateReq) {
        this.productId = UniqueIdGenerator.generateUniqueId(10);
        this.productName = productCreateReq.productName;
        this.price = productCreateReq.price;
    }

    public void displayProductDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }
  
}

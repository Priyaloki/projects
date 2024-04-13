package com.sample.thiran.retailManagementSystem.model;

import com.sample.thiran.retailManagementSystem.payload.ProductUpsertReq;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
// Specialized class for Clothing
@Getter
@Setter
@Entity
public class Clothing extends Product {
    private String size;

    public Clothing(){
        
    }

    public Clothing(ProductUpsertReq productCreateReq) {
        super(productCreateReq);
        this.size = productCreateReq.size;
    }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println("Size: " + size);
    }
}



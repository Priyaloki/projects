package com.sample.thiran.retailManagementSystem.model;

import com.sample.thiran.retailManagementSystem.payload.ProductUpsertReq;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Electronics extends Product{

    private String brand;

    public Electronics(){
        
    }

    public Electronics(ProductUpsertReq productCreateReq) {
        super(productCreateReq);
        this.brand = productCreateReq.brand;
    }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println("Brand: " + brand);
    }
    
}

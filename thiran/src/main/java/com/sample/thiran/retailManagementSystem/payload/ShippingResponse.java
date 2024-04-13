package com.sample.thiran.retailManagementSystem.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingResponse {

    private String trackingNumber;
    private double shippingCost;
    private String deliveryDate;
    private String status;

    // // Constructors, getters, and setters
    // public ShippingResponse() {
    //     // Default constructor
    // }
    
}

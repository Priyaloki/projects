package com.sample.thiran.retailManagementSystem.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingReq {

    private String senderName;
    private String senderAddress;
    private String senderCity;
    private String senderState;
    private String senderZipCode;

    private String recipientName;
    private String recipientAddress;
    private String recipientCity;
    private String recipientState;
    private String recipientZipCode;

    private double packageWeight;
    private String packageDimensions;
    private String shippingMethod;

    public ShippingReq() {
        // Default constructor
    }
    
}

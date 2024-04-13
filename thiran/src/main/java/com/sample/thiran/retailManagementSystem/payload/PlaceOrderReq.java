package com.sample.thiran.retailManagementSystem.payload;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceOrderReq {
    @NotEmpty(message = "The list must contain at least one value")
    public Map<String, Integer> orderItems;
    public String recipientName;
    public String shippingAddress;
    public String shippingCity;
    public String shippingState;
    public String shippingZipCode;
    public Double packageWeight;
    
    
}

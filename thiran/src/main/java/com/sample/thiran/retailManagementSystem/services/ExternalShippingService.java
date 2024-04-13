package com.sample.thiran.retailManagementSystem.services;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.thiran.retailManagementSystem.model.Order;
import com.sample.thiran.retailManagementSystem.model.OrderStatus;
import com.sample.thiran.retailManagementSystem.payload.PlaceOrderReq;
import com.sample.thiran.retailManagementSystem.payload.ShippingReq;
import com.sample.thiran.retailManagementSystem.payload.ShippingResponse;

@Service
public class ExternalShippingService{

    @Autowired
    RestTemplate restTemplate;


    private static final String API_URL = "https://api.usps.com/shipping/1.0/ship";

    public Order ship(PlaceOrderReq placeOrderReq,Order order) throws ShippingException {
        try {
            // Prepare request
            ShippingReq shippingRequest = prepareShippingRequest(placeOrderReq);
            
            // Send request and handle response
            // ShippingResponse shippingResponse = restTemplate.postForObject(API_URL, shippingRequest, ShippingResponse.class);

            // Update order status based on response
            order.setStatus(OrderStatus.SHIPPED);
            // order.setTrackingNumber(shippingResponse.getTrackingNumber());
            order.trackingNumber = generateTrackingNumber(10);
            // You may update other order details as needed

            return order;
        } catch (Exception e) {
            throw new ShippingException("Failed to ship order: " + e.getMessage());
        }
    }


    private ShippingReq prepareShippingRequest(PlaceOrderReq placeOrderReq) {
        // Construct a ShippingRequest object based on the order details
        ShippingReq shippingRequest = new ShippingReq();
    
        // Set sender information
        shippingRequest.setSenderName("Your Company");
        shippingRequest.setSenderAddress("123 Main St");
        shippingRequest.setSenderCity("Your City");
        shippingRequest.setSenderState("Your State");
        shippingRequest.setSenderZipCode("12345");
        // Add more sender details as needed
    
        // Set recipient information
        shippingRequest.setRecipientName(placeOrderReq.getRecipientName());
        shippingRequest.setRecipientAddress(placeOrderReq.getShippingAddress());
        shippingRequest.setRecipientCity(placeOrderReq.getShippingCity());
        shippingRequest.setRecipientState(placeOrderReq.getShippingState());
        shippingRequest.setRecipientZipCode(placeOrderReq.getShippingZipCode());
        // Add more recipient details as needed
    
        // Set package details
        shippingRequest.setPackageWeight(placeOrderReq.getPackageWeight());
        // Add more package details as needed
    
        return shippingRequest;
    }

    private static String generateTrackingNumber(int length) {
        
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom RANDOM = new SecureRandom();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}


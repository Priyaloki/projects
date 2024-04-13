package com.sample.thiran.retailManagementSystem.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.thiran.retailManagementSystem.model.Order;
import com.sample.thiran.retailManagementSystem.payload.PlaceOrderReq;

@Service
public class ShippingService {

    @Autowired
    private ExternalShippingService externalShippingService;

    private static final Logger logger = LoggerFactory.getLogger(ShippingService.class);


    // Method to simulate order shipment
    public Order shipOrder(PlaceOrderReq placeOrderReq,Order order) throws ShippingException {
        try {
            Order successOrder = externalShippingService.ship(placeOrderReq,order);
            logger.info("Order has been shipped successfully.");
            return successOrder;
        } catch (ShippingException e) {
            logger.error("Failed to ship order ", e.getMessage());
            // Handle the error, e.g., notify the customer or retry shipment
            // For simplicity, we'll rethrow the exception
            throw e;
        } catch (Exception e) {
            logger.error("An unexpected error occurred while shipping order ", e.getMessage());
            // Handle other unexpected errors
            // For simplicity, we'll wrap the exception and throw a new ShippingException
            throw new ShippingException("Unexpected error occurred while shipping order.");
        }
    }
    
}

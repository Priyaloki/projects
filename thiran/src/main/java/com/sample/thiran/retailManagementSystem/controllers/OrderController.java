package com.sample.thiran.retailManagementSystem.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.thiran.retailManagementSystem.payload.PlaceOrderReq;
import com.sample.thiran.retailManagementSystem.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController{

    @Autowired
    OrderService orderService;

    // API to place an order
    @PostMapping("/place-order")
    public ResponseEntity<?> placeOrder(@RequestBody PlaceOrderReq placeOrderReq) {
        try {
            return new ResponseEntity<>(orderService.fulfillOrder(placeOrderReq), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to place order: " + e.getMessage());
        }
    }

}
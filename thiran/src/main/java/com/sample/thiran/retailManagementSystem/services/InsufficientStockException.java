package com.sample.thiran.retailManagementSystem.services;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(String message) {
        super(message);
    }
    
}

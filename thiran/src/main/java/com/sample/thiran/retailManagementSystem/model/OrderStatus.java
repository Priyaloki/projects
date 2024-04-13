package com.sample.thiran.retailManagementSystem.model;

public enum OrderStatus {
    PENDING(0),
    SHIPPED(1),
    DELIVERED(2),
    CANCELLED(3);

    private final int statusCode;

    OrderStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
    
}

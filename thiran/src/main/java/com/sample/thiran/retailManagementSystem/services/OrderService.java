package com.sample.thiran.retailManagementSystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.thiran.retailManagementSystem.commons.UniqueIdGenerator;
import com.sample.thiran.retailManagementSystem.model.Inventory;
import com.sample.thiran.retailManagementSystem.model.Order;
import com.sample.thiran.retailManagementSystem.model.OrderItem;
import com.sample.thiran.retailManagementSystem.model.OrderStatus;
import com.sample.thiran.retailManagementSystem.payload.PlaceOrderReq;
import com.sample.thiran.retailManagementSystem.repository.InventoryRepository;
import com.sample.thiran.retailManagementSystem.repository.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private OrderRepository orderRepository;


    public Order fulfillOrder(PlaceOrderReq placeOrderReq) {
        Order order = new Order();
        Order successOrder = null;

        Boolean checkAvailability = checkProductsAvailability(placeOrderReq.orderItems);

        if(checkAvailability == true){
            for (Map.Entry<String, Integer> entry : placeOrderReq.orderItems.entrySet()) {
                String productId = entry.getKey();
                int quantity = entry.getValue();
    
                // Retrieve the inventory for the product
                Inventory inventory = inventoryRepository.findByProductId(productId);
                
                // Check if the product exists in inventory
                if (inventory != null) {
                    int availableQuantity = inventory.getQuantity();
                    
                    // Update inventory after fulfilling the order
                    inventory.setQuantity(availableQuantity - quantity);
                    inventoryRepository.save(inventory);
    
                    OrderItem orderItem = new OrderItem(productId, quantity);
                    order.addItem(orderItem);
    
                }
            }
            order.orderId = UniqueIdGenerator.generateUniqueId(10);
            order.recipientName = placeOrderReq.recipientName;
            order.shippingAddress = placeOrderReq.shippingAddress;
            order.shippingCity = placeOrderReq.shippingCity;
            order.shippingState = placeOrderReq.shippingState;
            order.shippingZipCode = placeOrderReq.shippingZipCode;
            order.packageWeight = placeOrderReq.packageWeight;
            order.status = OrderStatus.PENDING;
            orderRepository.save(order);
    
            try {
                successOrder = shippingService.shipOrder(placeOrderReq,order);
                if(successOrder != null){
                    Optional<Order> orderOptional = orderRepository.findById(successOrder.orderId);
                    if(orderOptional.isPresent() == true){
                        Order orderData = orderOptional.get();
                        orderData.status = OrderStatus.SHIPPED;

                        orderRepository.save(orderData);
                    }
                }

                return successOrder;
            } catch (ShippingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return successOrder;
    }

    public Boolean checkProductsAvailability(Map<String, Integer> orderItems) throws InsufficientStockException,RuntimeException{

        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String productId = entry.getKey();
            int quantity = entry.getValue();

            // Retrieve the inventory for the product
            Inventory inventory = inventoryRepository.findByProductId(productId);
            
            // Check if the product exists in inventory
            if (inventory != null) {
                int availableQuantity = inventory.getQuantity();
                
                // Check if there is enough stock to fulfill the order
                if (availableQuantity < quantity) {
                    throw new InsufficientStockException("Insufficient stock for product: " + productId);
                }else{
                    return true;
                }
            } else {
                throw new RuntimeException("Product not found in inventory: " + productId);
            }
        }
        return null;

    }
}

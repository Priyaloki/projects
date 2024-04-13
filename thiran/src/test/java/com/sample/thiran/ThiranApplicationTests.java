package com.sample.thiran;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ThiranApplicationTests {

	// @Test
    // void testAddProductToInventory_Success() throws OutOfStockException {
        
    //     Product product = new Product("1", "Laptop", 999.99);
    //     int initialStock = 10;

    //     Inventory inventory = new Inventory();
	// 	inventory.addProduct(product, initialStock);
    // }

	// @Test
    // void testFulfillOrder_Success() {

	// 	Inventory inventory = new Inventory();

	// 	Electronics laptop = new Electronics("1", "Laptop", 999.99, "Dell");
    //     Clothing shirt = new Clothing("2", "Shirt", 29.99, "Medium");

	// 	// Create an order
    //     Order order = new Order();
    //     order.addItem(new OrderItem(laptop, 8));
    //     order.addItem(new OrderItem(shirt, 3));

    //    // Fulfill the order
	//    try {
	// 		inventory.fulfillOrder(order);
	// 		System.out.println("Order procesed successfully!!!");
	// 		for(Product product : inventory.stockLevels.keySet()){
	// 			System.out.println(product.getProductName()+ " " + inventory.stockLevels.get(product));
	// 		}

	// 	} catch (OutOfStockException e) {
	// 		System.out.println("Failed to fulfill order: " + e.getMessage());
	// 	}
    // }

	// @Test
    // void testFulfillOrder_OutOfStock() {

	// 	Inventory inventory = new Inventory();

	// 	Electronics laptop = new Electronics("1", "Laptop", 999.99, "Dell");
    //     Clothing shirt = new Clothing("2", "Shirt", 29.99, "Medium");

	// 	// Create an order
    //     Order order = new Order();
    //     order.addItem(new OrderItem(laptop, 8));
    //     order.addItem(new OrderItem(shirt, 3));

    //    // Fulfill the order
	//    try {
	// 		inventory.fulfillOrder(order);
	// 		// System.out.println("Order procesed successfully!!!");
	// 		for(Product product : inventory.stockLevels.keySet()){
	// 			System.out.println(product.getProductName()+ " " + inventory.stockLevels.get(product));
	// 		}

	// 	} catch (OutOfStockException e) {
	// 		System.out.println("Failed to fulfill order: " + e.getMessage());
	// 	}
    // }
}

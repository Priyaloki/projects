package com.sample.thiran.retailManagementSystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.thiran.retailManagementSystem.model.Clothing;
import com.sample.thiran.retailManagementSystem.model.Electronics;
import com.sample.thiran.retailManagementSystem.model.Product;
import com.sample.thiran.retailManagementSystem.payload.ProductUpsertReq;
import com.sample.thiran.retailManagementSystem.services.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController{

    @Autowired
    ProductService productService;

    // API to add cloth products
    @PostMapping("/add/clothing")
    public ResponseEntity<?> addClothingProduct(@RequestBody ProductUpsertReq productCreateReq) {
        try{
            return new ResponseEntity<>(productService.createClothingProduct(productCreateReq), HttpStatus.CREATED);

        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
        
    }

    // API to add electronics product
    @PostMapping("/add/electronics")
    public ResponseEntity<?> addElectronicsProduct(@RequestBody ProductUpsertReq productCreateReq) {
        try{
            return new ResponseEntity<>(productService.createElectronicsProduct(productCreateReq), HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
        
    }

    // API to get all cloth products
    @GetMapping("/all/cloth-products")
    public List<Clothing> getAllClothProducts() {
        return productService.getClothProducts();
    }

    // API to get all electronics products
    @GetMapping("/all/electronic-products")
    public List<Electronics> getAllElectronicProducts() {
        return productService.getElectronicProducts();
    }

    // API to delete cloth product
    @DeleteMapping("/cloth-product/{id}")
    public ResponseEntity<Void> deleteClothProduct(@PathVariable String id) {
        productService.deleteClothProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // API to delete electronics product
    @DeleteMapping("/electronics-product/{id}")
    public ResponseEntity<Void> deleteElectronicsProduct(@PathVariable String id) {
        productService.deleteElectronicsProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // API to get cloth product
    @GetMapping("/get/cloth-product/{id}")
    public ResponseEntity<Clothing> getClothProductById(@PathVariable String id) {
        Optional<Clothing> product = productService.getClothProductById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // API to get electronic product
    @GetMapping("/get/electronics-product/{id}")
    public ResponseEntity<Electronics> getElectronicsProductById(@PathVariable String id) {
        Optional<Electronics> product = productService.getElectronicsProductById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // API to update quantity
    @PutMapping("/update/quantity")
    public ResponseEntity<?> updateProductQuantity(@RequestBody ProductUpsertReq productCreateReq) {
        try{
            return new ResponseEntity<>(productService.updateProduct(productCreateReq), HttpStatus.CREATED);

        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
        
    }


}
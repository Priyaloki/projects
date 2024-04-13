package com.sample.thiran.retailManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.thiran.retailManagementSystem.model.Clothing;
import com.sample.thiran.retailManagementSystem.model.Electronics;
import com.sample.thiran.retailManagementSystem.payload.ProductUpsertReq;
import com.sample.thiran.retailManagementSystem.repository.ClothingRepository;
import com.sample.thiran.retailManagementSystem.repository.ElectronicsRepository;

@Service
public class ProductService {

    @Autowired
    private ClothingRepository clothingRepository;

    @Autowired
    private ElectronicsRepository electronicsRepository;

    @Autowired
    private InventoryService inventoryService;

    public List<Clothing> getClothProducts() {
        List<Clothing> clothProducts = clothingRepository.findAll();
        clothProducts.stream().forEach(element->{
            element.displayProductDetails();
        });
        return clothProducts;
    }

    public List<Electronics> getElectronicProducts() {
        List<Electronics> electronicsProducts = electronicsRepository.findAll();
        electronicsProducts.stream().forEach(element->{
            element.displayProductDetails();
        });
        return electronicsProducts;
    }

    public Optional<Clothing> getClothProductById(String id) {
        return clothingRepository.findById(id);
    }

    public Optional<Electronics> getElectronicsProductById(String id) {
        return electronicsRepository.findById(id);
    }

    public String updateProduct(ProductUpsertReq productUpsertReq){
        if(productUpsertReq.type.equals("clothing") ){
            Optional<Clothing> productOptional = clothingRepository.findById(productUpsertReq.id); 

            if(productOptional.isPresent() == true){
                Clothing clothProduct = productOptional.get();
                    
                inventoryService.saveInventoryDetails(clothProduct.productId,productUpsertReq.quantity);
    
                return "product updated successfully";
            }else{
                throw new RuntimeException("Invalid product id");
            }
        }
        else if(productUpsertReq.type.equals("electronics")){

            Optional<Electronics> productOptional = electronicsRepository.findById(productUpsertReq.id); 

            if(productOptional.isPresent() == true){
                Electronics electronicsProduct = productOptional.get();
                    
                inventoryService.saveInventoryDetails(electronicsProduct.productId,productUpsertReq.quantity);
    
                return "product updated successfully";
            }else{
                throw new RuntimeException("Invalid product id");
            }

        }

        return null;
    }

    public void deleteClothProduct(String id) {
        clothingRepository.deleteById(id);
    }

    public void deleteElectronicsProduct(String id) {
        electronicsRepository.deleteById(id);
    }

    public String createClothingProduct(ProductUpsertReq productCreateReq){
        Clothing clothProduct = new Clothing(productCreateReq);
        clothingRepository.save(clothProduct);
        clothProduct.displayProductDetails();
        inventoryService.saveInventoryDetails(clothProduct.productId,productCreateReq.quantity);
        
        return "product created successfully "+ clothProduct.productId;
    }
    
    public String createElectronicsProduct(ProductUpsertReq productCreateReq){
        Electronics electronicProduct = new Electronics(productCreateReq);
        electronicProduct.displayProductDetails();
        electronicsRepository.save(electronicProduct);
        inventoryService.saveInventoryDetails(electronicProduct.productId,productCreateReq.quantity);

        return "product created successfully "+ electronicProduct.productId;
    }
}

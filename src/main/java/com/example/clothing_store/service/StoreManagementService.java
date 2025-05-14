package com.example.clothing_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothing_store.entities.ProductEntity;
import com.example.clothing_store.repository.ProductRepository;

@Service
public class StoreManagementService implements IShopService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductEntity postProduct(ProductEntity producto) {
        return productRepository.save(producto);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity updatedProduct, Long id) {
        ProductEntity productToUpdate = productRepository.findById(id).get();
        productToUpdate.setName(updatedProduct.getName());
        productToUpdate.setType(updatedProduct.getType());
        productToUpdate.setStock(updatedProduct.getStock());
        productToUpdate.setCostPrice(updatedProduct.getCostPrice());
        return productRepository.save(productToUpdate);
    }

    @Override
    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}

package com.example.clothing_store.map;

import com.example.clothing_store.dto.ProductDTO;
import com.example.clothing_store.entities.ProductEntity;

public class ProductMapper {
    public static ProductDTO toDTO(ProductEntity product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getType(),
                Integer.valueOf(product.getStock()),
                Integer.valueOf(product.getCostPrice()),
                product.getSalePrice()
        );
    }
}

package com.example.clothing_store.service;

import com.example.clothing_store.entities.ProductEntity;

public interface IShopService {

    ProductEntity postProduct(ProductEntity producto);
    ProductEntity updateProduct(ProductEntity productoModificado, Long id);

    boolean deleteProduct(Long id);
}

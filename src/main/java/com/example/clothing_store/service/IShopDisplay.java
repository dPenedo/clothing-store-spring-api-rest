package com.example.clothing_store.service;

import com.example.clothing_store.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IShopDisplay {
    List<ProductDTO> getAllProducts();

    List<ProductDTO> getOutOfStockProducts();

    Optional<ProductDTO> getById(Long id);

    List<ProductDTO> getProductsByType(String tipo);

    List<ProductDTO> getProductsByClient();

    List<ProductDTO> getProductsByTypeByClient(String tipo);
}

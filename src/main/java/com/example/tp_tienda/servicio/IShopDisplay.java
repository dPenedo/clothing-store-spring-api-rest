package com.example.tp_tienda.servicio;

import com.example.tp_tienda.dto.ProductDTO;

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

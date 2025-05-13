package com.example.tp_tienda.map;

import com.example.tp_tienda.dto.ProductDTO;
import com.example.tp_tienda.entidades.ProductEntity;

public class ProductMapper {
    public static ProductDTO toDTO(ProductEntity producto){
        return new ProductDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getTipo(),
                producto.getStock(),
                producto.getPrecioCosto(),
                producto.getPrecioVenta()
        );
    }
}

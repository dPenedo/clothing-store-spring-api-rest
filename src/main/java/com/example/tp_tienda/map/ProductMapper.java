package com.example.tp_tienda.map;

import com.example.tp_tienda.dto.ProductDTO;
import com.example.tp_tienda.entidades.ProductoEntidad;

public class ProductMapper {
    public static ProductDTO toDTO(ProductoEntidad producto){
        return new ProductDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getTipo(),
                producto.getPrecioCosto(),
                producto.getPrecioVenta()
        );
    }
}

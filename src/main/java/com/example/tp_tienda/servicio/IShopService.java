package com.example.tp_tienda.servicio;

import com.example.tp_tienda.entidades.ProductEntity;

public interface IShopService {

    ProductEntity postProduct(ProductEntity producto);
    ProductEntity updateProduct(ProductEntity productoModificado, Long id);

    boolean deleteProduct(Long id);
}

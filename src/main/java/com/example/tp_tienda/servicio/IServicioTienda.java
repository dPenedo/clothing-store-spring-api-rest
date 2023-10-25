package com.example.tp_tienda.servicio;

import com.example.tp_tienda.entidades.ProductoEntidad;

import java.util.ArrayList;

public interface IServicioTienda {

    ProductoEntidad guardarProducto(ProductoEntidad producto);
    ProductoEntidad actualizarProducto(ProductoEntidad productoModificado, Long id);

    boolean eliminarProducto(Long id);
}

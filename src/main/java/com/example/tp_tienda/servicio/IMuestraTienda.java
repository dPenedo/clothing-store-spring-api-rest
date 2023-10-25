package com.example.tp_tienda.servicio;

import com.example.tp_tienda.entidades.ProductoEntidad;

import java.util.ArrayList;
import java.util.Optional;

public interface IMuestraTienda {
    ArrayList<ProductoEntidad> obtenerProductos();

    String obtenerProductosParaCliente();

    String obtenerAgotados();

    Optional<ProductoEntidad> obtenerPorId(Long id);

    ArrayList<ProductoEntidad> obtenerPorTipo(String tipo);

    String obtenerPorTipoCliente(String tipo);
}

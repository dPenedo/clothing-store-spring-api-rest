package com.example.tp_tienda.servicio;

import com.example.tp_tienda.dto.ProductDTO;
import com.example.tp_tienda.entidades.ProductoEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IMuestraTienda {
    List<ProductDTO> obtenerProductos();

    String obtenerProductosParaCliente();

    List<ProductDTO> obtenerAgotados();

    Optional<ProductoEntidad> obtenerPorId(Long id);

    ArrayList<ProductoEntidad> obtenerPorTipo(String tipo);

    String obtenerPorTipoCliente(String tipo);
}

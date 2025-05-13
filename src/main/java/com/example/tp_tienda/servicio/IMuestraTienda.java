package com.example.tp_tienda.servicio;

import com.example.tp_tienda.dto.ProductDTO;
import com.example.tp_tienda.entidades.ProductoEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IMuestraTienda {
    List<ProductDTO> obtenerProductos();

    List<ProductDTO> obtenerAgotados();

    Optional<ProductDTO> obtenerPorId(Long id);

    List<ProductDTO> obtenerPorTipo(String tipo);

    List<ProductDTO> obtenerProductosParaCliente();

    List<ProductDTO> obtenerPorTipoCliente(String tipo);
}

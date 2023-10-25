package com.example.tp_tienda.repositorio;

import java.util.ArrayList;

import com.example.tp_tienda.entidades.TipoProducto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tp_tienda.entidades.ProductoEntidad;

@Repository
public interface ProductoRepositorio extends CrudRepository<ProductoEntidad, Long> {
    public abstract ArrayList<ProductoEntidad> findByTipo(TipoProducto tipo);
}

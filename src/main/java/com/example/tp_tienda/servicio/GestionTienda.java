package com.example.tp_tienda.servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp_tienda.entidades.ProductoEntidad;
import com.example.tp_tienda.repositorio.ProductoRepositorio;

@Service
public class GestionTienda implements IServicioTienda {
    @Autowired
    ProductoRepositorio productoRepositorio;
    @Override
    public ProductoEntidad guardarProducto(ProductoEntidad producto){
        return productoRepositorio.save(producto);
    }
    @Override
    public ProductoEntidad actualizarProducto(ProductoEntidad productoModificado, Long id){
        ProductoEntidad productoAux = productoRepositorio.findById(id).get();
        productoAux.setNombre(productoModificado.getNombre());
        productoAux.setTipo(productoModificado.getTipo());
        productoAux.setStock(productoModificado.getStock());
        productoAux.setPrecioCosto(productoModificado.getPrecioCosto());
        return productoRepositorio.save(productoAux);
    }

    @Override
    public boolean eliminarProducto(Long id){
        try{
            productoRepositorio.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }



}

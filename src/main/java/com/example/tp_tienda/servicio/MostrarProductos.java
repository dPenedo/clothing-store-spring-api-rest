package com.example.tp_tienda.servicio;

import com.example.tp_tienda.entidades.ProductoEntidad;
import com.example.tp_tienda.entidades.TipoProducto;
import com.example.tp_tienda.repositorio.ProductoRepositorio;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MostrarProductos implements IMuestraTienda {
    @Autowired
    ProductoRepositorio productoRepositorio;
    @Autowired
    Gson gson;
    @Override
    public ArrayList<ProductoEntidad> obtenerProductos() {
        return (ArrayList<ProductoEntidad>) productoRepositorio.findAll();
    }

    @Override
    public String obtenerProductosParaCliente() {
        ArrayList<ProductoEntidad> productosCompletos = (ArrayList<ProductoEntidad>) productoRepositorio.findAll();
        ArrayList<JsonObject> productosSinCosto = new ArrayList<>();
        for(ProductoEntidad producto : productosCompletos){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", producto.getId());
            jsonObject.addProperty("nombre", producto.getNombre());
            if (producto.getTipo() != TipoProducto.SIN_TIPO){
                jsonObject.addProperty("tipo",producto.getTipo().toString());
            }
            // Indica el stock únicamente si quedan menos de 10 unidades
            if (producto.getStock() < 10){
                jsonObject.addProperty("stock", producto.getStock());
            }
//            jsonObject.addProperty("stock", producto.getStock());
            jsonObject.addProperty("precioVenta", producto.getPrecioVenta());

            productosSinCosto.add(jsonObject);
        }
        return gson.toJson(productosSinCosto);
    }

    @Override
    public String obtenerAgotados() {
        ArrayList<ProductoEntidad> productosCompletos = (ArrayList<ProductoEntidad>) productoRepositorio.findAll();
        ArrayList<JsonObject> productosAgotados = new ArrayList<>();
        for(ProductoEntidad producto : productosCompletos){
            if(producto.getStock()== 0){
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("id", producto.getId());
                jsonObject.addProperty("nombre", producto.getNombre());
                jsonObject.addProperty("tipo", producto.getTipo().toString());
                jsonObject.addProperty("precioCosto", producto.getPrecioCosto());
                jsonObject.addProperty("precioVenta", producto.getPrecioVenta());
                productosAgotados.add(jsonObject);
            }
        }
        return gson.toJson(productosAgotados);
    }

    @Override
    public Optional<ProductoEntidad> obtenerPorId(Long id){
        return productoRepositorio.findById(id);
    }
    @Override
    public ArrayList<ProductoEntidad> obtenerPorTipo(String tipo){
        return productoRepositorio.findByTipo(TipoProducto.valueOf(tipo));
    }

    @Override
    public String obtenerPorTipoCliente(String tipo) {
        ArrayList<ProductoEntidad> productosCompletos = (ArrayList<ProductoEntidad>)  productoRepositorio.findByTipo(TipoProducto.valueOf(tipo));
        ArrayList<JsonObject> productosSinCosto =  new ArrayList<>();
        for(ProductoEntidad producto : productosCompletos){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", producto.getId());
            jsonObject.addProperty("nombre", producto.getNombre());
            // Indica el stock únicamente si quedan menos de 10 unidades
            if (producto.getStock() < 10){
                jsonObject.addProperty("stock", producto.getStock());
            }
//            jsonObject.addProperty("stock", producto.getStock());
            jsonObject.addProperty("precioVenta", producto.getPrecioVenta());

            productosSinCosto.add(jsonObject);
        }
        return gson.toJson(productosSinCosto);
    }
}

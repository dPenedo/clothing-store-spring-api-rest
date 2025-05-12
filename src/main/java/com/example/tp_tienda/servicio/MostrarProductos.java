package com.example.tp_tienda.servicio;

import com.example.tp_tienda.dto.ProductDTO;
import com.example.tp_tienda.entidades.ProductoEntidad;
import com.example.tp_tienda.entidades.TipoProducto;
import com.example.tp_tienda.map.ProductMapper;
import com.example.tp_tienda.repositorio.ProductoRepositorio;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.tp_tienda.map.ProductMapper.toDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MostrarProductos implements IMuestraTienda {
    @Autowired
    ProductoRepositorio productoRepositorio;
    @Autowired
    Gson gson;

    @Override
    public List<ProductDTO> obtenerProductos() {
        List<ProductoEntidad> productos = (List<ProductoEntidad>) productoRepositorio.findAll();
        return productos.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String obtenerProductosParaCliente() {
        ArrayList<ProductoEntidad> productosCompletos = (ArrayList<ProductoEntidad>) productoRepositorio.findAll();
        ArrayList<JsonObject> productosSinCosto = new ArrayList<>();
        for (ProductoEntidad producto : productosCompletos) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", producto.getId());
            jsonObject.addProperty("nombre", producto.getNombre());
            if (producto.getTipo() != TipoProducto.SIN_TIPO) {
                jsonObject.addProperty("tipo", producto.getTipo().toString());
            }
            // Indica el stock únicamente si quedan menos de 10 unidades
            if (producto.getStock() < 10) {
                jsonObject.addProperty("stock", producto.getStock());
            }
            // jsonObject.addProperty("stock", producto.getStock());
            jsonObject.addProperty("precioVenta", producto.getPrecioVenta());

            productosSinCosto.add(jsonObject);
        }
        return gson.toJson(productosSinCosto);
    }

    @Override
    public List<ProductDTO> obtenerAgotados() {
        List<ProductoEntidad> products = (List<ProductoEntidad>) productoRepositorio.findAll();
        List<ProductDTO> agotados = new ArrayList<>();
        for (ProductoEntidad producto : products) {
            if (producto.getStock() == 0) {
                agotados.add(new ProductDTO(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getTipo(),
                        producto.getPrecioCosto(),
                        producto.getPrecioVenta()));
            }
        }
        return agotados;
    }

    @Override
    public Optional<ProductoEntidad> obtenerPorId(Long id) {
        return productoRepositorio.findById(id);
    }

    @Override
    public ArrayList<ProductoEntidad> obtenerPorTipo(String tipo) {
        return productoRepositorio.findByTipo(TipoProducto.valueOf(tipo));
    }

    @Override
    public String obtenerPorTipoCliente(String tipo) {
        ArrayList<ProductoEntidad> productosCompletos = (ArrayList<ProductoEntidad>) productoRepositorio
                .findByTipo(TipoProducto.valueOf(tipo));
        ArrayList<JsonObject> productosSinCosto = new ArrayList<>();
        for (ProductoEntidad producto : productosCompletos) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", producto.getId());
            jsonObject.addProperty("nombre", producto.getNombre());
            // Indica el stock únicamente si quedan menos de 10 unidades
            if (producto.getStock() < 10) {
                jsonObject.addProperty("stock", producto.getStock());
            }
            // jsonObject.addProperty("stock", producto.getStock());
            jsonObject.addProperty("precioVenta", producto.getPrecioVenta());

            productosSinCosto.add(jsonObject);
        }
        return gson.toJson(productosSinCosto);
    }
}

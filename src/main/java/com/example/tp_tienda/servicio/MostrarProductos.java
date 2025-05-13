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

    @Override
    public List<ProductDTO> obtenerProductos() {
        ArrayList<ProductoEntidad> productosEnt = (ArrayList<ProductoEntidad>) productoRepositorio.findAll();
        List<ProductDTO> productos = (List<ProductDTO>) productosEnt.stream().map(prod -> toDTO(prod)).collect(Collectors.toList());
        return productos;
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
                        producto.getStock(),
                        producto.getPrecioCosto(),
                        producto.getPrecioVenta()));
            }
        }
        return agotados;
    }

    @Override
    public Optional<ProductDTO> obtenerPorId(Long id) {
        return productoRepositorio.findById(id).map(product -> new ProductDTO(product.getId(), product.getNombre(), product.getTipo(), product.getStock(), product.getPrecioCosto(), product.getPrecioVenta()));
    }

    @Override
    public List<ProductDTO> obtenerPorTipo(String tipo) {
        List<ProductoEntidad> productsEnt = productoRepositorio.findByTipo(TipoProducto.valueOf(tipo));
        List<ProductDTO> products = new ArrayList<>();
        List<ProductDTO> productos = (List<ProductDTO>) productsEnt.stream().map(prod -> toDTO(prod)).collect(Collectors.toList());
        return productos;
    }

    @Override
    public List<ProductDTO> obtenerProductosParaCliente() {
        List<ProductoEntidad> productosCompletos = (ArrayList<ProductoEntidad>) productoRepositorio.findAll();
        List<ProductDTO> productosSinCosto = new ArrayList<>();
        for (ProductoEntidad producto : productosCompletos) {
            ProductDTO prodDTO = new ProductDTO(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getTipo(),
                    producto.getStock() < 10 ? producto.getStock() : null,
                    null,
                    producto.getPrecioVenta()
            );
            productosSinCosto.add(prodDTO);
        }
        return productosSinCosto;
    }

    @Override
    public List<ProductDTO> obtenerPorTipoCliente(String tipo) {
        List <ProductoEntidad> productosCompletos = (ArrayList<ProductoEntidad>) productoRepositorio
                .findByTipo(TipoProducto.valueOf(tipo));
        List<ProductDTO> productosSinCosto = new ArrayList<>();
        for (ProductoEntidad producto : productosCompletos) {
            if (producto.getTipo().toString() == tipo){
            ProductDTO productDTO = new ProductDTO(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getTipo(),
                    producto.getStock() < 10 ? producto.getStock() : null,
                    null,
                    producto.getPrecioVenta()
            );
                productosSinCosto.add(productDTO);
            }
        }
        return productosSinCosto;
    }
}

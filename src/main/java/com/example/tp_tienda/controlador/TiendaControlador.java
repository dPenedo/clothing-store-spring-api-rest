package com.example.tp_tienda.controlador;

import com.example.tp_tienda.entidades.ProductoEntidad;
import com.example.tp_tienda.servicio.Homepage;
import com.example.tp_tienda.servicio.MostrarProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.tp_tienda.servicio.GestionTienda;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class TiendaControlador {
    @Autowired
    private Homepage homepage;

    @GetMapping()
    private String paginaHomepage() {
        return homepage.mostrarHomepage();
    }

    @Autowired
    private GestionTienda gestionTienda;

    //Guardar usuario como admin
    @PostMapping("/admin")
    private ProductoEntidad guardarProducto(@RequestBody ProductoEntidad producto) {
        return this.gestionTienda.guardarProducto(producto);
    }

    @PutMapping("/admin/{id}")
    private ProductoEntidad modificarProducto(@PathVariable("id") Long id, @RequestBody ProductoEntidad producto) {
        return this.gestionTienda.actualizarProducto(producto, id);
    }

    @DeleteMapping("/admin/{id}")
    private String eliminarPorId(@PathVariable("id") Long id) {
        boolean productoEliminado = gestionTienda.eliminarProducto(id);
        if (productoEliminado) {
            return "El producto " + id + " ha sido eliminado";
        } else {
            return "No se ha podido eliminar el producto " + id;
        }
    }

    @Autowired
    private MostrarProductos mostrarProductos;

    @GetMapping("/admin")
    private ArrayList<ProductoEntidad> obtenerProductos() {
        return mostrarProductos.obtenerProductos();
    }

    @GetMapping("/admin/{id}")
    private Optional<ProductoEntidad> obtenerProductoPorId(@PathVariable("id") Long id) {
        return this.mostrarProductos.obtenerPorId(id);
    }

    @GetMapping("/admin/agotados")
    private String obtenerProductosAgotados() {
        return mostrarProductos.obtenerAgotados();
    }

    @GetMapping("/admin/tipo")
    private ArrayList<ProductoEntidad> obtenerProductoPorTipoVacio() {
        return this.mostrarProductos.obtenerProductos();
    }

    @GetMapping("/admin/tipo/{tipo}")
    private ArrayList<ProductoEntidad> obtenerProductoPorTipo(@PathVariable("tipo") String tipo) {
        return this.mostrarProductos.obtenerPorTipo(tipo);
    }

    @GetMapping("/cliente")
    private String obtenerProductosParaCliente() {
        return mostrarProductos.obtenerProductosParaCliente();
    }

    @GetMapping("/cliente/tipo/{tipo}")
    private String obtenerProductosPorTipoParaCliente(@PathVariable("tipo") String tipo) {
        return mostrarProductos.obtenerPorTipoCliente(tipo);
    }
}
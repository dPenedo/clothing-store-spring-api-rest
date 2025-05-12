package com.example.tp_tienda.dto;

import com.example.tp_tienda.entidades.TipoProducto;

public class ProductDTO {
    private Long id;
    private String nombre;
    private TipoProducto tipo = TipoProducto.SIN_TIPO;
    private int stock;
    private int precioCosto;
    private int precioVenta;

    public ProductDTO(Long id, String nombre, TipoProducto tipoProducto, int precioCosto, int precioVenta) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(int precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }
}

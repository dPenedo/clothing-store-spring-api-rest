package com.example.tp_tienda.dto;

import com.example.tp_tienda.entidades.TipoProducto;

public class ProductDTO {
    private Long id;
    private String nombre;
    private TipoProducto tipo = TipoProducto.SIN_TIPO;
    private Integer stock;
    private Integer precioCosto;
    private int precioVenta;

    public ProductDTO(Long id, String nombre, TipoProducto tipoProducto, Integer stock, Integer precioCosto, int precioVenta) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipoProducto;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Integer precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }
}

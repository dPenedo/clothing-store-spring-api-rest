package com.example.tp_tienda.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private TipoProducto tipo = TipoProducto.SIN_TIPO;
    private int stock;

    private int precioCosto;
    private int precioVenta;

    public ProductoEntidad() {
    }

    public ProductoEntidad(Long id, String nombre, TipoProducto tipo, int stock, int precioCosto, int precioVenta) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = TipoProducto.SIN_TIPO;
        this.stock = stock;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
    }

    public Long getId() {
        return id;
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
        if (tipo == null) {
            this.tipo = TipoProducto.SIN_TIPO;
        } else {
            this.tipo = tipo;
        }
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
        this.precioVenta = (int) (precioCosto + (precioCosto * 0.5));
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

}

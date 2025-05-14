package com.example.clothing_store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private TypeProduct type = TypeProduct.NO_TYPE;
    private int stock;
    private int costPrice;
    private int salePrice;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, TypeProduct type, int stock, int costPrice, int salePrice) {
        this.id = id;
        this.name = name;
        this.type = TypeProduct.NO_TYPE;
        this.stock = stock;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct tipo) {
        if (tipo == null) {
            this.type = TypeProduct.NO_TYPE;
        } else {
            this.type = tipo;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice
    ) {
        this.costPrice = costPrice;
        this.salePrice = (int) (costPrice + (costPrice * 0.5));
    }

    public int getSalePrice() {
        return salePrice;
    }

}

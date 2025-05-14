package com.example.clothing_store.dto;

import com.example.clothing_store.entities.TypeProduct;

public class ProductDTO {
    private Long id;
    private String name;
    private TypeProduct type = TypeProduct.NO_TYPE;
    private Integer stock;
    private Integer costPrice;
    private int sellPrice;

    public ProductDTO(Long id, String name, TypeProduct typeProduct, Integer stock, Integer costPrice, int sellPrice) {
        this.id = id;
        this.name = name;
        this.type = typeProduct;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setType(TypeProduct type) {
        this.type = type;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
}

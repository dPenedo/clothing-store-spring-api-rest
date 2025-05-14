package com.example.clothing_store.repository;

import java.util.ArrayList;

import com.example.clothing_store.entities.TypeProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.clothing_store.entities.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    public abstract ArrayList<ProductEntity> findByType(TypeProduct type);
}

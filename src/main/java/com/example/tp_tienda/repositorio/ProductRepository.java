package com.example.tp_tienda.repositorio;

import java.util.ArrayList;

import com.example.tp_tienda.entidades.TypeProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tp_tienda.entidades.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    public abstract ArrayList<ProductEntity> findByTipo(TypeProduct tipo);
}

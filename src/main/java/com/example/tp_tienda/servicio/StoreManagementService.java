package com.example.tp_tienda.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp_tienda.entidades.ProductEntity;
import com.example.tp_tienda.repositorio.ProductRepository;

@Service
public class StoreManagementService implements IShopService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductEntity postProduct(ProductEntity producto) {
        return productRepository.save(producto);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity updatedProduct, Long id) {
        ProductEntity productToUpdate = productRepository.findById(id).get();
        productToUpdate.setNombre(updatedProduct.getNombre());
        productToUpdate.setTipo(updatedProduct.getTipo());
        productToUpdate.setStock(updatedProduct.getStock());
        productToUpdate.setPrecioCosto(updatedProduct.getPrecioCosto());
        return productRepository.save(productToUpdate);
    }

    @Override
    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}

package com.example.clothing_store.service;

import com.example.clothing_store.dto.ProductDTO;
import com.example.clothing_store.entities.ProductEntity;
import com.example.clothing_store.entities.TypeProduct;
import com.example.clothing_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.clothing_store.map.ProductMapper.toDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductDisplayService implements IShopDisplay {
    @Autowired
    ProductRepository productRepository;

    @Override
    // TODO: Arreglar, devuelve stock como null
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productsEnt = (List<ProductEntity>) productRepository.findAll();
        List<ProductDTO> products = productsEnt.stream().map(prod -> toDTO(prod))
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public List<ProductDTO> getOutOfStockProducts() {
        List<ProductEntity> products = (List<ProductEntity>) productRepository.findAll();
        List<ProductDTO> outOfStockProducts = new ArrayList<>();
        for (ProductEntity product : products) {
            if (product.getStock() == 0) {
                outOfStockProducts.add(new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getType(),
                        product.getStock(),
                        product.getCostPrice(),
                        product.getSalePrice()));
            }
        }
        return outOfStockProducts;
    }

    @Override
    public List<String> getListOfTypeOfProducts() {
        List<String> listOfTypes = new ArrayList<>();
        for (TypeProduct typeProduct : TypeProduct.values()) {
            listOfTypes.add(typeProduct.toString());
        }
        return listOfTypes;
    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        return productRepository.findById(id).map(product -> new ProductDTO(product.getId(), product.getName(),
                product.getType(), product.getStock(), product.getCostPrice(), product.getSalePrice()));
    }

    @Override
    public List<ProductDTO> getProductsByType(String type) {
        TypeProduct typeProduct;
        try {
            typeProduct = TypeProduct.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return List.of();
        }
        List<ProductEntity> productsEnt = productRepository.findByType(typeProduct);
        List<ProductDTO> products = (List<ProductDTO>) productsEnt.stream().map(prod -> toDTO(prod))
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public List<ProductDTO> getProductsByClient() {
        List<ProductEntity> listOfAllProducts = (List<ProductEntity>) productRepository.findAll();
        List<ProductDTO> productsForClient = new ArrayList<>();
        for (ProductEntity product : listOfAllProducts) {
            ProductDTO prodDTO = new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getType(),
                    product.getStock() < 10 ? product.getStock() : null,
                    null,
                    product.getSalePrice());
            productsForClient.add(prodDTO);
        }
        return productsForClient;
    }

    @Override
    public List<ProductDTO> getProductsByTypeByClient(String type) {
        TypeProduct typeProduct;
        try {
            typeProduct = TypeProduct.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return List.of();
        }
        List<ProductEntity> productsByType = productRepository
                .findByType(typeProduct);
        List<ProductDTO> productsForClient = new ArrayList<>();
        for (ProductEntity prod : productsByType) {
                ProductDTO productDTO = new ProductDTO(
                        prod.getId(),
                        prod.getName(),
                        prod.getType(),
                        prod.getStock() < 10 ? prod.getStock() : null,
                        null,
                        prod.getSalePrice());
                productsForClient.add(productDTO);
        }
        return productsForClient;
    }
}

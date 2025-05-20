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
    public List<ProductDTO> getAllProducts() {
        ArrayList<ProductEntity> productsEnt = (ArrayList<ProductEntity>) productRepository.findAll();
        List<ProductDTO> products = (List<ProductDTO>) productsEnt.stream().map(prod -> toDTO(prod))
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
        List<ProductEntity> productsEnt = productRepository.findByType(TypeProduct.valueOf(type));
        List<ProductDTO> products = (List<ProductDTO>) productsEnt.stream().map(prod -> toDTO(prod))
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public List<ProductDTO> getProductsByClient() {
        List<ProductEntity> listOfAllProducts = (ArrayList<ProductEntity>) productRepository.findAll();
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
        List<ProductEntity> allProducts = (ArrayList<ProductEntity>) productRepository
                .findByType(TypeProduct.valueOf(type));
        List<ProductDTO> productsForClient = new ArrayList<>();
        for (ProductEntity producto : allProducts) {
            if (producto.getType().toString() == type) {
                ProductDTO productDTO = new ProductDTO(
                        producto.getId(),
                        producto.getName(),
                        producto.getType(),
                        producto.getStock() < 10 ? producto.getStock() : null,
                        null,
                        producto.getSalePrice());
                productsForClient.add(productDTO);
            }
        }
        return productsForClient;
    }
}

package com.example.tp_tienda.servicio;

import com.example.tp_tienda.dto.ProductDTO;
import com.example.tp_tienda.entidades.ProductEntity;
import com.example.tp_tienda.entidades.TypeProduct;
import com.example.tp_tienda.repositorio.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.tp_tienda.map.ProductMapper.toDTO;

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
        List<ProductDTO> products = (List<ProductDTO>) productsEnt.stream().map(prod -> toDTO(prod)).collect(Collectors.toList());
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
                        product.getNombre(),
                        product.getTipo(),
                        product.getStock(),
                        product.getPrecioCosto(),
                        product.getPrecioVenta()));
            }
        }
        return outOfStockProducts;
    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        return productRepository.findById(id).map(product -> new ProductDTO(product.getId(), product.getNombre(), product.getTipo(), product.getStock(), product.getPrecioCosto(), product.getPrecioVenta()));
    }

    @Override
    public List<ProductDTO> getProductsByType(String tipo) {
        List<ProductEntity> productsEnt = productRepository.findByTipo(TypeProduct.valueOf(tipo));
        List<ProductDTO> products = new ArrayList<>();
        List<ProductDTO> productos = (List<ProductDTO>) productsEnt.stream().map(prod -> toDTO(prod)).collect(Collectors.toList());
        return productos;
    }

    @Override
    public List<ProductDTO> getProductsByClient() {
        List<ProductEntity> listOfAllProducts = (ArrayList<ProductEntity>) productRepository.findAll();
        List<ProductDTO> productsForClient = new ArrayList<>();
        for (ProductEntity product : listOfAllProducts) {
            ProductDTO prodDTO = new ProductDTO(
                    product.getId(),
                    product.getNombre(),
                    product.getTipo(),
                    product.getStock() < 10 ? product.getStock() : null,
                    null,
                    product.getPrecioVenta()
            );
            productsForClient.add(prodDTO);
        }
        return productsForClient;
    }

    @Override
    public List<ProductDTO> getProductsByTypeByClient(String type) {
        List <ProductEntity> allProducts = (ArrayList<ProductEntity>) productRepository
                .findByTipo(TypeProduct.valueOf(type));
        List<ProductDTO> productsForClient = new ArrayList<>();
        for (ProductEntity producto : allProducts) {
            if (producto.getTipo().toString() == type){
            ProductDTO productDTO = new ProductDTO(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getTipo(),
                    producto.getStock() < 10 ? producto.getStock() : null,
                    null,
                    producto.getPrecioVenta()
            );
                productsForClient.add(productDTO);
            }
        }
        return productsForClient;
    }
}
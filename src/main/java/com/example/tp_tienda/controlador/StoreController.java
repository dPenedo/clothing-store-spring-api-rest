package com.example.tp_tienda.controlador;

import com.example.tp_tienda.dto.ProductDTO;
import com.example.tp_tienda.entidades.ProductEntity;
import com.example.tp_tienda.entidades.TypeProduct;
import com.example.tp_tienda.servicio.HomepageService;
import com.example.tp_tienda.servicio.ProductDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.tp_tienda.servicio.StoreManagementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class StoreController {
    @Autowired
    private HomepageService homepage;

    @GetMapping()
    private String getHomepage() {
        return homepage.getHomepage();
    }

    @Autowired
    private StoreManagementService storeManagementService;

    // Post product as admin
    @PostMapping("/admin")
    private ProductEntity postProduct(@RequestBody ProductEntity product) {
        return this.storeManagementService.postProduct(product);
    }

    @PutMapping("/admin/{id}")
    private ProductEntity updateProduct(@PathVariable("id") Long id, @RequestBody ProductEntity product) {
        return this.storeManagementService.updateProduct(product, id);
    }

    @DeleteMapping("/admin/{id}")
    private String deleteById(@PathVariable("id") Long id) {
        boolean isProductDeleted = storeManagementService.deleteProduct(id);
        if (isProductDeleted) {
            return "The product " + id + " has been deleted";
        } else {
            return "Could not delete the product " + id;
        }
    }

    @Autowired
    private ProductDisplayService productDisplayService;

    @GetMapping("/admin")
    private List<ProductDTO> getAllProducts() {
        return productDisplayService.getAllProducts();
    }

    @GetMapping("/admin/{id}")
    private Optional<ProductDTO> getProductById(@PathVariable("id") Long id) {
        return this.productDisplayService.getById(id);
    }

    @GetMapping("/admin/agotados")
    private List<ProductDTO> getOutOfStockProducts() {
        return productDisplayService.getOutOfStockProducts();
    }

//    @GetMapping("/admin/tipo")
//    private <ProductoEntidad> obtenerProductoPorTipoVacio() {
//        return this.mostrarProductos.obtenerProductos();
//    }

    @GetMapping("/admin/tipo/{tipo}")
    private List<ProductDTO> getProductsByType(@PathVariable("tipo") String type) {
        TypeProduct typeEnum = TypeProduct.valueOf(type.toUpperCase());
        return this.productDisplayService.getProductsByType(typeEnum.toString());
    }

    @GetMapping("/cliente")
    private List <ProductDTO> getProductsByClient() {
        return productDisplayService.getProductsByClient();
    }

    @GetMapping("/cliente/tipo/{tipo}")
    private List <ProductDTO> getProductsByTypeByClient(@PathVariable("tipo") String type) {
        TypeProduct typeEnum = TypeProduct.valueOf(type.toUpperCase());
        return productDisplayService.getProductsByTypeByClient(typeEnum.toString());
    }
}

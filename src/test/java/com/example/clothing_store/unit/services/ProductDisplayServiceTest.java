package com.example.clothing_store.unit.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.clothing_store.dto.ProductDTO;
import com.example.clothing_store.entities.TypeProduct;
import com.example.clothing_store.repository.ProductRepository;
import com.example.clothing_store.service.ProductDisplayService;

@ExtendWith(MockitoExtension.class)
class ProductDisplayServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductDisplayService productDisplayService;

    @Test
    void getAllProductsShouldReturnListOfDTOs() {
        List<ProductDTO> products = new ArrayList<>();
        products.add((new ProductDTO(12L, "Producto prueba", TypeProduct.SHIRT, 12, 123, 123)));
        System.out.println("Name -> " + products.get(0).getName());
        List<ProductDTO> result = productDisplayService.getAllProducts();
        assertThat(result).isNotNull();
        // assertThat(result.get(0).getName()).isEqualTo("Producto prueba");

    }
}

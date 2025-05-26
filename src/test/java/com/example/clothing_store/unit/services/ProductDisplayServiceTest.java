package com.example.clothing_store.unit.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.clothing_store.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        List<ProductEntity> mockProducts = List.of(new ProductEntity(1L, "Shirt", TypeProduct.SHIRT, 12, 120, 12000));
        when(productRepository.findAll()).thenReturn(mockProducts);
        List<ProductDTO> result = productDisplayService.getAllProducts();
        assertThat(result).isNotNull().hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Shirt");
    }

    @Test
    void getOutOfStockProductsShoudReturnProductsWithNoStock() {
        List<ProductEntity> mockProducts = List.of((new ProductEntity(1L, "Shirt", TypeProduct.SHIRT, 0, 120, 12000)),(new ProductEntity(2L, "Second shirrt", TypeProduct.SHIRT, 2, 120, 12000)));
        when(productRepository.findAll()).thenReturn(mockProducts);
        List<ProductDTO> result = productDisplayService.getOutOfStockProducts();
        assertThat(result).isNotNull().hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Shirt");
    }

    @Test
    void getListOfTypesReturnsAListOfStringsWithTypes() {
        List<String> listOfTypes = productDisplayService.getListOfTypeOfProducts();
        assertThat(listOfTypes)
                .isNotNull()
                .isNotEmpty();
        assertThat(listOfTypes.get(0))
                .isEqualTo("SHOES");
        assertThat(listOfTypes.get(1))
                .isEqualTo("PANTS");
    }
    @Test
    void getByIDReturnsProductById() {
        ProductEntity product = new ProductEntity(2L, "that is", TypeProduct.PANTS, 23, 2300, 1200);
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));

        Optional<ProductDTO> result = productDisplayService.getById(2L);

        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("that is");
    }

//    @Test
//    void getProductsByTypeReturnsProductsOnlyIfTheTypeMatches(){
//        List<ProductEntity> mockProducts = List.of((new ProductEntity(1L, "Pants", TypeProduct.PANTS, 3, 2300, 1200)),(new ProductEntity(2L, "otros pants", TypeProduct.SHIRT, 23, 2300, 1200)));
//        when(productRepository.findAll()).thenReturn(mockProducts);
//        List<ProductDTO> resultPants = productDisplayService.getProductsByType("PANTS");
//        assertThat(resultPants)
//                .isNotNull();
//    }

    @Test
    void getProductsByClientShouldShowTheStockOnlyIfIsBelow10Units(){
        List<ProductEntity> mockProducts = List.of((new ProductEntity(1L, "Pants", TypeProduct.PANTS, 3, 2300, 1200)),(new ProductEntity(2L, "otros pants", TypeProduct.PANTS, 23, 2300, 1200)));
        when(productRepository.findAll()).thenReturn(mockProducts);
        List<ProductDTO> result = productDisplayService.getProductsByClient();
        assertThat(result)
                .isNotNull()
                .hasSize(2);
        assertThat(result.get(0).getStock()).isEqualTo(3);
        assertThat(result.get(1).getStock()).isEqualTo(null);
    }


}

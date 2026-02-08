package org.example.controller;

import org.example.entity.Product;
import org.example.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    void getAllProducts_ShouldReturnProductList() {
        // Given
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Test Product 1");
        
        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Test Product 2");
        
        List<Product> products = Arrays.asList(product1, product2);
        when(productService.getAllProducts()).thenReturn(products);

        // When
        List<Product> result = productController.getAllProducts();

        // Then
        assertEquals(2, result.size());
        assertEquals("Test Product 1", result.get(0).getName());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void createProduct_ShouldReturnCreatedProduct() {
        // Given
        Product product = new Product();
        product.setName("New Product");
        product.setPrice(100.0);
        
        when(productService.createProduct(product)).thenReturn(product);

        // When
        Product result = productController.createProduct(product);

        // Then
        assertEquals("New Product", result.getName());
        assertEquals(100.0, result.getPrice());
        verify(productService, times(1)).createProduct(product);
    }
}
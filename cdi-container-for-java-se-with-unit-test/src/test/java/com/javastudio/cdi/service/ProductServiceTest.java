package com.javastudio.cdi.service;

import com.javastudio.cdi.api.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class ProductServiceTest {

    ProductService productService = Mockito.mock(ProductService.class);

    @BeforeEach
    void setUp() {
        Mockito.when(productService.findAll()).thenReturn(Collections.emptyList());
    }

    @Test
    void givenMockProductService_whenFindAllProducts_thenEmptyListWillReturn() {
        assertTimeout(Duration.ofMillis(100), () -> {
            assertEquals(productService.findAll().size(), 0);
        });
    }
}
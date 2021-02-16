package com.javastudio.cdi.service;

import com.javastudio.cdi.api.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@ExtendWith(MockitoExtension.class)
class ProductService2Test {

    @Mock
    private ProductService productService;

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
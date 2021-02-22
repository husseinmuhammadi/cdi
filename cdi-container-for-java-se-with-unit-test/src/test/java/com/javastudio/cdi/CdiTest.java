package com.javastudio.cdi;

import com.javastudio.cdi.api.ProductService;
import com.javastudio.cdi.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class CdiTest {

    @Test
    void test() {
        try (final SeContainer container = SeContainerInitializer.newInstance()
                .disableDiscovery()
                .addBeanClasses(ProductService.class, ProductServiceImpl.class)
                .initialize()) {
            ProductService productService = container.select(ProductService.class).get();
            Assertions.assertEquals(productService.findAll().size(), 0);
        }
    }
}

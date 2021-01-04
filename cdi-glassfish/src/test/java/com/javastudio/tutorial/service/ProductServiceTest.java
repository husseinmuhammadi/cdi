package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.ProductService;
import com.javastudio.tutorial.dao.ProductDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Flow;

class ProductServiceTest {

    @Inject
    ProductService productService;

    @BeforeEach
    void setUp() {
        ServiceLocator locator = ServiceLocatorUtilities.bind(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(ProductServiceImpl.class).to(ProductService.class).in(Singleton.class);
                bind(new ProductDao()).to(ProductDao.class);
            }
        });
        locator.inject(this);
    }

    @Test
    void name() {
        Assertions.assertThat(productService).isNotNull();
        productService.finalAll();

        Flow
    }
}
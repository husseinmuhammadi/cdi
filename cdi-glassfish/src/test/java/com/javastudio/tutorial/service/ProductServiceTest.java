package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.ProductService;
import com.javastudio.tutorial.dao.ProductDao;
import org.assertj.core.api.Assertions;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

class ProductServiceTest {

    private Logger logger = LoggerFactory.getLogger(ProductServiceTest.class);

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
        productService.finalAll()
                .stream()
                .map(product -> String.format("%d-%s", product.getId(), product.getName()))
                .forEach(logger::info);
    }
}
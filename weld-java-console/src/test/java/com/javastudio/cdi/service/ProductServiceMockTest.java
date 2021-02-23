package com.javastudio.cdi.service;

import com.javastudio.cdi.api.ProductService;
import com.javastudio.cdi.dao.ProductRepository;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

@EnableWeld
class ProductServiceMockTest {

    @WeldSetup
    private WeldInitiator weld = WeldInitiator.from(ProductService.class, ProductRepository.class, Logger.class).build();

    @Test
    void test(ProductService productService) {
        productService.ok();
    }
}

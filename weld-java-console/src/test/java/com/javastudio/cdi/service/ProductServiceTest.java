package com.javastudio.cdi.service;

import com.javastudio.cdi.api.ProductService;
import org.jboss.weld.junit5.EnableWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

/**
 * 1. Weld container is started/stopped automatically.
 * 2. By default, only the content of the test package is discovered by Weld.
 * 3. Test class is injected automatically.
 */
@EnableWeld
class ProductServiceTest {

    @Inject
    ProductService productService;

    @Test
    void test() {
        productService.ok();
    }

}
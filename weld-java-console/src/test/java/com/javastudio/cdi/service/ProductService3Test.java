package com.javastudio.cdi.service;

import com.javastudio.cdi.api.ProductService;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

@EnableWeld
class ProductService3Test {

    @WeldSetup
    private WeldInitiator weld = WeldInitiator.performDefaultDiscovery();

    @Test
    void test(ProductService productService) {
        productService.ok();
    }
}

package com.javastudio.cdi.service;

import com.javastudio.cdi.api.ProductService;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * 1. Weld container is started/stopped automatically.
 * 2. By default, only the content of the test package is discovered by Weld.
 * 3. Test class is injected automatically.
 */
@EnableWeld
public class ProductServiceWithDefaultDiscoveryTest {

//    @WeldSetup
//    public WeldInitiator weld = WeldInitiator.from(ProductService.class, ProductServiceImpl.class)
//            .activate(RequestScoped.class)
//            .build();

    @WeldSetup
    private WeldInitiator weld = WeldInitiator.performDefaultDiscovery();

    @Inject
    ProductService productService;

    @Test
    void test() {
        productService.ok();
    }
}
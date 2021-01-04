package com.javastudio.tutorial;

import com.javastudio.tutorial.api.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class Application {

    @Inject
    Configuration configuration;

    @Inject
    ProductService productService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Hello world!");
    }

    public void demo() {
        productService.finalAll();
    }
}

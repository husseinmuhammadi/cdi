package com.javastudio.cdi.dao;

import org.slf4j.Logger;

import javax.inject.Inject;

public class ProductRepository {
    @Inject
    private Logger logger;

    public void save() {
        logger.info("ProductRepository -> save");
    }
}

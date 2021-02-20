package com.javastudio.cdi.service;

import com.javastudio.cdi.api.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public void ok() {
        logger.info("ProductServiceImpl -> ok");
    }
}

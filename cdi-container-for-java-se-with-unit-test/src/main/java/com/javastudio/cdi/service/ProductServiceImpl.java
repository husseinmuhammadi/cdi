package com.javastudio.cdi.service;

import com.javastudio.cdi.api.ProductService;
import com.javastudio.cdi.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public List<Product> findAll() {
        logger.info("ProductServiceImpl -> findAll");
        return Collections.emptyList();
    }
}

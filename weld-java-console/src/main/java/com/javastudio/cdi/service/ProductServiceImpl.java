package com.javastudio.cdi.service;

import com.javastudio.cdi.api.ProductService;
import com.javastudio.cdi.dao.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class ProductServiceImpl implements ProductService {

    @Inject
    private Logger logger;

    @Inject
    private ProductRepository repository;

    @Override
    public void ok() {
        logger.info("ProductServiceImpl -> ok");
        repository.save();
    }
}

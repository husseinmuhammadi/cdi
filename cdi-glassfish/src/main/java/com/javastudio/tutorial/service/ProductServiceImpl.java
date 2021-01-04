package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.ProductService;
import com.javastudio.tutorial.dao.ProductDao;
import com.javastudio.tutorial.model.Product;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Inject
    ProductDao productDao;

    @Override
    public List<Product> finalAll(){
        return productDao.findAll();
    }

}

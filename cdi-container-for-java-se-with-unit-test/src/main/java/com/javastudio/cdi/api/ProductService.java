package com.javastudio.cdi.api;

import com.javastudio.cdi.dto.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
}

package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.model.Product;

import java.util.List;

public class ProductDao {
    public List<Product> findAll() {
        return List.of(
                Product.builder().id(1).name("Nail").build(),
                Product.builder().id(2).name("Hammer").build(),
                Product.builder().id(3).name("Axe").build()
        );
    }
}

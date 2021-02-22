package com.javastudio.cdi.dto;

import java.util.List;

public class Order {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

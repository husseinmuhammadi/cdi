package com.javastudio.tutorial.model;

public class Product {
    private final int id;
    private final String name;

    public Product(ProductBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private int id;
        private String name;

        public ProductBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Product build() {
            Product product = new Product(this);
            validateProductObject();
            return product;
        }

        private void validateProductObject() {

        }
    }
}

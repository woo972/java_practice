package com.hexagonal.product.application.port.in;

import lombok.Getter;

@Getter
public class ProductName {
    private final String value;

    public ProductName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name can't be null");
        }
        if (name.length() > 4) {
            throw new IllegalArgumentException("product name have to be longer than 4 characters");
        }
        this.value = name;
    }

}

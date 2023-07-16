package com.hexagonal.product.application.port.in;

public class Stock {
    private int value;
    public Stock(int stock) {
        requireGreaterThan(stock, -1);
        this.value = stock;
    }

    private void requireGreaterThan(int targetInput, int baseLine) {
        if (targetInput <= baseLine) {
            throw new IllegalArgumentException("stock value has to be greater or equal than 0");
        }
    }
}

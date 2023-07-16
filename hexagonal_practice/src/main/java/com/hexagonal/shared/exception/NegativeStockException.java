package com.hexagonal.shared.exception;

public class NegativeStockException extends Throwable {
    public NegativeStockException(String msg) {
        super(msg);
    }
}

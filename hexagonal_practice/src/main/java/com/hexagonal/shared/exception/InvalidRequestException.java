package com.hexagonal.shared.exception;

public class InvalidRequestException extends Throwable {
    public InvalidRequestException(String msg) {
        super(msg);
    }
}

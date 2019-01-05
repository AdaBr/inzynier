package com.example.library.commons;

public class DataValidationException extends RuntimeException {

    public DataValidationException() {
        super();
    }

    public DataValidationException(String message) {
        super(message);
    }

    public DataValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

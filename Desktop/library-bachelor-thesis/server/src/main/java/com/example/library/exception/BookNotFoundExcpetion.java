package com.example.library.exception;

public class BookNotFoundExcpetion extends RuntimeException {

    public BookNotFoundExcpetion(Long id) {
        super("Could not found book " +id);
    }


    public BookNotFoundExcpetion(String title) {
        super("Could not found book " +title);
    }
}

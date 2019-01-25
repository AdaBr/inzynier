package com.example.library.commons;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(Long id) {
        super ("Could not find author " + id);

    }

    public AuthorNotFoundException(String name) {
        super ("Could not find author " + name);
    }
}

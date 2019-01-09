package com.example.library.author;

class AuthorNotFoundException extends RuntimeException {

    AuthorNotFoundException(Long id) {
        super ("Could not find author " + id);

    }

    public AuthorNotFoundException(String name) {
        super ("Could not find author " + name);
    }
}

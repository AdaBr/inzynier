package com.example.library.book;

class BookNotFoundExcpetion extends RuntimeException {
    BookNotFoundExcpetion(Long id) {
        super("Could not found book " +id);
    }


    public BookNotFoundExcpetion(String title) {
        super("Could not found book " +title);
    }
}

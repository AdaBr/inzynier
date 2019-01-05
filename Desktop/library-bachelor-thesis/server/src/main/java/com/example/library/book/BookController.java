package com.example.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/good-books")
    public Collection<Book> goodBeers() {

        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Book book) {
        return !book.getTitle().equals("Budweiser") &&
                !book.getTitle().equals("Coors Light") &&
                !book.getTitle().equals("PBR");
    }
}


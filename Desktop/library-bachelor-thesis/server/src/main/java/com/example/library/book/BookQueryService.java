package com.example.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookQueryService {

    @Autowired
    private BookRepository bookRepository;

    List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    Book getBook(Book book) {
        Book result = bookRepository.getOne(book.getId());
        return result;
    }

    Book getBook(Long id) {
        return bookRepository.getOne(id);
    }


}

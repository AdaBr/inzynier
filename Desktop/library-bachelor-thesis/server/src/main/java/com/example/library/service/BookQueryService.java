package com.example.library.service;

import com.example.library.exception.BookNotFoundExcpetion;
import com.example.library.repository.BookRepository;
import com.example.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookQueryService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> list=this.bookRepository.findAll();
        System.out.println("test");
        return this.bookRepository.findAll();
    }


    public Book getBook(Book book) {
        return this.bookRepository.findById(book.getId()).orElseThrow(()-> new BookNotFoundExcpetion(book.getId()));
    }

    public Book getBook(Long id) {
        return this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundExcpetion(id));
    }


}

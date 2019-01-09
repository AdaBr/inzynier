package com.example.library.book;

import com.example.library.author.AuthorSearchService;
import com.example.library.authorbook.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookQueryService {

    @Autowired
    private BookRepository bookRepository;


    List<Book> getAllBooks() {
        List<Book> list=this.bookRepository.findAll();
        System.out.println("test");
        return this.bookRepository.findAll();
    }


    Book getBook(Book book) {
        return this.bookRepository.findById(book.getId()).orElseThrow(()-> new BookNotFoundExcpetion(book.getId()));
    }

    Book getBook(Long id) {
        return this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundExcpetion(id));
    }


}

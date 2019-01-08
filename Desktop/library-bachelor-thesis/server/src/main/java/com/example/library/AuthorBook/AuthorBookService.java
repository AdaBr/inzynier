package com.example.library.AuthorBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookService {

    @Autowired
    private AuthorBookRepository authorBookRepository;


    void createAuthorBook(AuthorBook authorBook) {
        this.authorBookRepository.save(authorBook);
    }

    AuthorBook getAuthorBook(AuthorBookIdentity authorBookIdentity) {
        return this.authorBookRepository.findById(authorBookIdentity).orElse(null);
    }

    List<AuthorBook> getAll() {
        return this.authorBookRepository.findAll();

    }


    void removeAllAuthors() {
        this.authorBookRepository.deleteAll();
    }


}

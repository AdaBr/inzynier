package com.example.library.author;

import com.example.library.commons.DataValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    void createAuthor(Author author) {
        this.authorRepository.save(author);
    }

    Author getAuthor(Long id) {
        return this.authorRepository.findById(id).orElse(null);
    }


    List<Author> getAll() {
        return this.authorRepository.findAll();
    }

    void removeAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }

    void removeAuthor(Author author) {
        this.authorRepository.delete(author);
    }

    void removeAllAuthors() {
        this.authorRepository.deleteAll();
    }
}

package com.example.library.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorQueryService {

    @Autowired
    private AuthorRepository authorRepository;

    List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    Author getAuthor(Author author) {
        return authorRepository.findById(author.getId()).orElse(null);
    }

    Author getAuthor(Long id) {
        return authorRepository.findById(id).orElse(null);
    }
}

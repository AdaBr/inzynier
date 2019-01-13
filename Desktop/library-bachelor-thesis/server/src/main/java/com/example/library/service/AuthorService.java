package com.example.library.service;

import com.example.library.exception.AuthorNotFoundException;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void createAuthor(Author author) {
        this.authorRepository.save(author);
    }

    public Author getAuthor(Long id) {
        return this.authorRepository.findById(id).orElseThrow(() ->new AuthorNotFoundException(id));
    }

    public List<Author> getAll() {
        return this.authorRepository.findAll();
    }

    public void removeAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }

    public void removeAllAuthors() {
        this.authorRepository.deleteAll();
    }


    public String authorsName(List<Long> authorsID) {
        String authorsNames= "";

        List<Author> authorList= authorRepository.findAllById(authorsID);
        for (Author author : authorList) {
            authorsNames +=  author.getForename().getValue() + " " + author.getSurname() + ", ";

        }
        return authorsNames.substring(0, authorsNames.length()-2);
    }
}

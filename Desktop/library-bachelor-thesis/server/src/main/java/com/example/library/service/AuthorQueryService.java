package com.example.library.service;

import com.example.library.exception.AuthorNotFoundException;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorQueryService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Author author) {
        return authorRepository.findById(author.getId()).orElse(null);
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
    }

    public List<Author> getAuthorByName(String name) {
        List<Author> result= new ArrayList<Author>();

        boolean findSurname=false;
        for (Author author : this.authorRepository.findAll()) {
            if (name.toLowerCase().contains(author.getSurname().toString().toLowerCase()) ||
                    author.getSurname().toString().toLowerCase().contains(name.toLowerCase())) {
                findSurname=true;
                if (name.toLowerCase().contains(author.getForename().toString().toLowerCase()) ||
                        author.getForename().toString().toLowerCase().contains(name.toLowerCase())) {
                    Author author1 = this.authorRepository.findById(author.getId()).orElseThrow(() -> new AuthorNotFoundException(name));
                    result.add(author1);
                } else if (!name.toLowerCase().contains(author.getForename().toString().toLowerCase()) &&
                        !author.getForename().toString().toLowerCase().contains(name.toLowerCase())) {
                    Author author1 = this.authorRepository.findById(author.getId()).orElseThrow(() -> new AuthorNotFoundException(name));
                    result.add(author1);
                }
            }
        }

        if (!findSurname) {
            for (Author author : this.authorRepository.findAll()) {
                if (name.toLowerCase().contains(author.getForename().toString().toLowerCase()) ||
                        author.getForename().toString().toLowerCase().contains(name.toLowerCase())) {
                    Author author1 = this.authorRepository.findById(author.getId()).orElseThrow(() -> new AuthorNotFoundException(name));
                    result.add(author1);
                }
            }
        }

        return result;

    }
}

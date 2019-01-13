package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorSearchService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorQueryService authorQueryService;

    @Autowired
    private AuthorBookService authorBookService;


    public List<Long> getAuthorsIDSearchByName(String name) {

        List<Long> authorsID = new ArrayList<Long>();
        List<Author> authors = authorQueryService.getAuthorByName(name);

        for (Author author : authors) {
            authorsID.add(author.getId());
        }

        return authorsID;

    }

    public List<Author> getAuthorsForBook(Long id) {

        List<Long> authorsID = authorBookService.getAuthorsIDWithBookID(id);
        return  this.authorRepository.findAllById(authorsID);


    }



}

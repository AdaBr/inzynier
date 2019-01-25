package com.example.library.service;

import com.example.library.commons.AuthorNotFoundException;
import com.example.library.model.Author;
import com.example.library.model.AuthorBook;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorBookService authorBookService;


    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Author author) {
        return authorRepository.findById(author.getId()).orElse(null);
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
    }

    public String authorsName(List<Long> authorsID) {
        String authorsNames = "";

        for (Author author : authorRepository.findAllById(authorsID)) {
            authorsNames +=  author.getForename().getValue() + " " + author.getSurname() + ", ";
        }
        return authorsNames.substring(0, authorsNames.length()-2);
    }


    public List<Author> getAuthorsForBook(Long id) {

        List<Long> authorsID = new ArrayList<>();
        for (AuthorBook authorBook : authorBookService.getAuthorsIDWithBookID(id)) {
            authorsID.add(authorBook.getAuthorBookIdentity().getAuthorID());
        }
        return  this.authorRepository.findAllById(authorsID);


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

    public List<Long> getAuthorsIDSearchByName(String name) {

        List<Long> authorsID = new ArrayList<Long>();
        List<Author> authors = getAuthorByName(name);

        for (Author author : authors) {
            authorsID.add(author.getId());
        }

        return authorsID;

    }

    /*
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
    */

}

package com.example.library.service;

import com.example.library.model.AuthorBook;
import com.example.library.repository.AuthorBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorBookService {

    @Autowired
    private AuthorBookRepository authorBookRepository;


    public List<AuthorBook> getAllAuthorBooks() {

        return this.authorBookRepository.findAll();

    }

    public List<AuthorBook> getBooksIDWithAuthorsID(Long authorID) {

        return authorBookRepository.findByAuthorBookIdentity_AuthorID(authorID);
    }

    public List<AuthorBook> getAuthorsIDWithBookID(Long bookID) {

        return authorBookRepository.findByAuthorBookIdentity_BookID(bookID);
    }

    /* rozwiazane systemowo findBy JPA
    public List<Long> getBooksIDWithAuthorsID(List<Long> authorsID) {
        List<Long> booksID = new ArrayList<Long>();

        for (AuthorBook authorBook : this.authorBookRepository.findAll()) {
            for (Long authorID : authorsID) {
                if (authorBook.getAuthorBookIdentity().getAuthorID().equals(authorID)) {
                    booksID.add(authorBook.getAuthorBookIdentity().getBookID());
                }
            }
        }
        return booksID;
    }

    public List<Long> getAuthorsIDWithBookID(Long bookID) {

        List<Long> authorsID = new ArrayList<Long>();
        for (AuthorBook authorBook : this.authorBookRepository.findAll()) {
            if (authorBook.getAuthorBookIdentity().getBookID().equals(bookID)) {
                authorsID.add(authorBook.getAuthorBookIdentity().getAuthorID());
            }
        }
        return authorsID;
    }

    public List<Long> getAuthorsIDWithBooksID(List<Long> booksID) {

        List<Long> authorsID = new ArrayList<Long>();
        for (AuthorBook authorBook : this.authorBookRepository.findAll()) {
            for (Long bookID : booksID) {
                if (authorBook.getAuthorBookIdentity().getBookID().equals(bookID)) {
                    authorsID.add(authorBook.getAuthorBookIdentity().getAuthorID());
                }
            }
        }
        return authorsID;
    }

    */




  /*
    public void createAuthorBook(AuthorBook authorBook) {
        this.authorBookRepository.save(authorBook);
    }


    AuthorBook getAuthorBook(AuthorBookIdentity authorBookIdentity) {
        return this.authorBookRepository.findById(authorBookIdentity).orElse(null);
    }

    void getAuthorBook(AuthorBook authorBook) {

        return this.authorBookRepository.finddById(authorBook.getAuthorBookIdentity());
    }

    public void removeAllAuthorBooks() {
        this.authorBookRepository.deleteAll();
    }
    */













}

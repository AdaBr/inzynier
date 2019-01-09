package com.example.library.authorbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

}

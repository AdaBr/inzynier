package com.example.library;

import com.example.library.author.AuthorDto;
import com.example.library.author.AuthorFacade;
import com.example.library.book.BookDto;
import com.example.library.book.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class DevelopmentDataLoader implements ApplicationRunner {

    @Autowired
    private BookFacade bookFacade;

    @Autowired
    private AuthorFacade authorFacade;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        AuthorDto authorDto = new AuthorDto();
        authorDto.setForename("Katarzyna");
        authorDto.setSurname("Miller");

        authorFacade.addAuthor(authorDto);

        Long authorID = null;

        for (AuthorDto dto : authorFacade.getAllAuthors()) {
            authorID = dto.getId();
        }

        List<Long> authorsIDList = new ArrayList<>();

        authorsIDList.add(authorID);

        BookDto bookDto = new BookDto();
        bookDto.setISBN("978-83-65456-65-6");
        bookDto.setTitle("Instrukcja obslugi mezczyzny");
        bookDto.setAuthorsID(authorsIDList);
        bookFacade.addBook(bookDto);



    }
}

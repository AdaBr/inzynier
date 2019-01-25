package com.example.library;

import com.example.library.repository.dto.AuthorDto;
import com.example.library.service.facade.AuthorFacade;
import com.example.library.repository.dto.BookDto;
import com.example.library.service.facade.BookFacade;
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

        /*
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(new Long(4));
        authorDto.setForename("Katarzyna");
        authorDto.setSurname("Miller");

        authorFacade.addAuthor(authorDto);

        Long authorID = null;

        List<AuthorDto> authorsList = authorFacade.getAllAuthors();


        System.out.println("Cokolwike");
        for (AuthorDto dto : authorFacade.getAllAuthors()) {
            authorID = dto.getId();
        }


        List<Long> authorsIDList = new ArrayList<>();

        authorsIDList.add(authorID);


        BookDto bookDto = new BookDto();
        bookDto.setISBN("978-83-65456-65-6");
        bookDto.setBookTitle("Instrukcja obslugi mezczyzny");
        //bookDto.setAuthorsID(authorsIDList);
        bookFacade.addBook(bookDto);

        List<BookDto> booksList = bookFacade.getAllBooks();


        //booksList.get(0).setAuthorsID(authorsIDList);

        */

    }
}

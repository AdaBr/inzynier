package com.example.library.authorbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookFacade {

    @Autowired
    private AuthorBookService authorBookService;
    

    @Autowired
    private AuthorBookMapperDecorator mapper;

    public void addAuthorBook(AuthorBookDto authorBookDto) {
        AuthorBook authorBook = mapper.authorBookDtoToAuthorBook(authorBookDto);
        this.authorBookService.createAuthorBook(authorBook);
    }


    public List<AuthorBookDto> getAllAuthorBooks() {
        return this.mapper.authorBooksToAuthorBookDtos(this.authorBookService.getAllAuthorBooks());
    }

    public void removeAllAuthorBooks() {
        this.authorBookService.removeAllAuthorBooks();
    }

    /*
    public void removeAuthorBook(AuthorBookDto authorBookDto) {
        AuthorBook authorBook = mapper.authorBookDtoToAuthorBook(authorBookDto);
        authorBookService.removeAuthorBook(authorBook);

    }

    public AuthorBookDto getAuthorBook(AuthorBookDto authorBookdto) {
        AuthorBook authorBook = this.mapper.authorBookDtoToAuthorBook(authorBookdto);
        return this.mapper.authorBookToAuthorBookDto(authorBookService.getAuthorBook(authorBook));
    }


    public AuthorBookDto getAuthorBook(AuthorBookIdentity authorBookIdentity) {
        return this.mapper.authorBookToAuthorBookDto(authorBookService.getAuthorBook(authorBookIdentity));
    }

    */

}
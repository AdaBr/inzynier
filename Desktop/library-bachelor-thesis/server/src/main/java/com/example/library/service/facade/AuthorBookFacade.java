package com.example.library.service.facade;

import com.example.library.repository.mapper.AuthorBookMapperImpl;
import com.example.library.service.AuthorBookService;
import com.example.library.model.AuthorBook;
import com.example.library.repository.dto.AuthorBookDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookFacade {

    @Autowired
    private AuthorBookService authorBookService;

    @Autowired
    private AuthorBookMapperImpl mapper;


    public List<AuthorBookDto> getAllAuthorsBooks() {
        return this.mapper.authorBooksToAuthorBookDtos(this.authorBookService.getAllAuthorBooks());
    }



    /*
    public List<AuthorBookDto> getAllAuthorsBookstest(Long authorID) {
        return mapper.authorBooksToAuthorBookDtos(authorBookService.getAllAuthorBooksTest(authorID));
    }

*/
    /*

     public void removeAllAuthorBooks() {
        this.authorBookService.removeAllAuthorBooks();
    }


    public void addAuthorBook(AuthorBookDto authorBookDto) {
        AuthorBook authorBook = mapper.authorBookDtoToAuthorBook(authorBookDto);
        this.authorBookService.createAuthorBook(authorBook);
    }

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
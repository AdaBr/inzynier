package com.example.library.service.facade;

import com.example.library.repository.dto.AuthorDto;
import com.example.library.model.Author;
import com.example.library.repository.mapper.AuthorMapperImpl;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorFacade {

    @Autowired
    private AuthorService authorService;


    @Autowired
    private AuthorMapperImpl mapper;


    public AuthorDto getAuthor(Long id) {
        return this.mapper.authorToAuthorDto(authorService.getAuthor(id));
    }

    public AuthorDto getAuthor(AuthorDto authordto) {
        Author author = this.mapper.authorDtoToAuthor(authordto);
        return this.mapper.authorToAuthorDto(authorService.getAuthor(author));
    }

    public List<AuthorDto> getAllAuthors() {
        return this.mapper.authorsToAuthorDtos(this.authorService.getAllAuthors());
    }


    public List<AuthorDto> getAuthorByName(String name) {
        return this.mapper.authorsToAuthorDtos(authorService.getAuthorByName(name));
    }

    public List<AuthorDto> getAuthorsForBook(Long id) {

        return this.mapper.authorsToAuthorDtos(authorService.getAuthorsForBook(id));
    }

    /*
    public void addAuthor(AuthorDto authorDto) {
        Author author = mapper.authorDtoToAuthor(authorDto);
        this.authorService.createAuthor(author);
    }

    public void removeAuthor(Long id) {
        authorService.removeAuthor(id);

    }

    public void removeAllAuthors() {
        this.authorService.removeAllAuthors();
    }

     */


}
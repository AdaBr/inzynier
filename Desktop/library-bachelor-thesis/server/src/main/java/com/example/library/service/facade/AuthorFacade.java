package com.example.library.service.facade;

import com.example.library.repository.dto.AuthorDto;
import com.example.library.model.Author;
import com.example.library.repository.mapper.AuthorMapperImpl;
import com.example.library.service.AuthorQueryService;
import com.example.library.service.AuthorSearchService;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorFacade {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorQueryService authorQueryService;

    @Autowired
    private AuthorSearchService authorSearchService;

    @Autowired
    private AuthorMapperImpl mapper;

    public void addAuthor(AuthorDto authorDto) {
        Author author = mapper.authorDtoToAuthor(authorDto);
        this.authorService.createAuthor(author);
    }

    public AuthorDto getAuthor(Long id) {
        return this.mapper.authorToAuthorDto(authorQueryService.getAuthor(id));
    }

    public AuthorDto getAuthor(AuthorDto authordto) {
        Author author = this.mapper.authorDtoToAuthor(authordto);
        return this.mapper.authorToAuthorDto(authorQueryService.getAuthor(author));
    }

    public List<AuthorDto> getAllAuthors() {
        return this.mapper.authorsToAuthorDtos(this.authorService.getAll());
    }

    public void removeAuthor(Long id) {
        authorService.removeAuthor(id);

    }

    public void removeAllAuthors() {
        this.authorService.removeAllAuthors();
    }

    public List<AuthorDto> getAuthorByName(String name) {
        return this.mapper.authorsToAuthorDtos(authorQueryService.getAuthorByName(name));
    }

    public List<AuthorDto> getAuthorsForBook(Long id) {

        return this.mapper.authorsToAuthorDtos(authorSearchService.getAuthorsForBook(id));
    }
}
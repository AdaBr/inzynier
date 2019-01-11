package com.example.library.author;

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
    private AuthorMapperDecorator mapper;

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

    public void removeAuthor(AuthorDto authorDto) {
        Author author = mapper.authorDtoToAuthor(authorDto);
        authorService.removeAuthor(author);

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
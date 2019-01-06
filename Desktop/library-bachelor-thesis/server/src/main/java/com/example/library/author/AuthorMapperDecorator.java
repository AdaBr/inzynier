package com.example.library.author;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class AuthorMapperDecorator implements AuthorMapper{

    @Autowired
    private AuthorMapper delegate;



    @Override
    public AuthorDto authorToAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        BeanUtils.copyProperties(author, authorDto, "Surname", "Forename");
        authorDto.setForename(author.getForename().getValue());
        authorDto.setSurname(author.getSurname().getValue());


        //
        // modelMapper.map(author, AuthorDto.class);

        //AuthorDto authorDto = delegate.authorToAuthorDto(author);
        //authorDto.setForename(author.getForename().getValue());
        //authorDto.setSurname(author.getSurname().getValue());
        return authorDto;
    }

    @Override
    public Author authorDtoToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDto, author, "Surname", "Forename");
        author.setForename(new Forename(authorDto.getForename()));
        author.setSurname(new Surname(authorDto.getSurname()));


        /*
        //delegate.authorDtoToAuthor(authorDto);

        author.setForename(new Forename(authorDto.getForename()));
        author.setSurname(new Surname(authorDto.getSurname()));

        */
        return author;
    }

    List<AuthorDto> authorsToAuthorDtos(List<Author> authorList) {
        List<AuthorDto> authorDtoList = new ArrayList<>();
        authorList.stream().forEach(author -> authorDtoList.add(authorToAuthorDto(author)));
        return authorDtoList;
    }

    List<Author> authorDtosToAuthors(List<AuthorDto> authorDtoList) {
        List<Author> authorList = new ArrayList<>();
        authorDtoList.stream().forEach(authorDto -> authorList.add(authorDtoToAuthor(authorDto)));
        return authorList;
    }
}

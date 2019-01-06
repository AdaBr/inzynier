package com.example.library.author;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
interface AuthorMapper {

    Author authorDtoToAuthor(AuthorDto authorDto);

    AuthorDto authorToAuthorDto(Author author);

}

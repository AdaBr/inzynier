package com.example.library.repository.mapper;

import com.example.library.model.Author;
import com.example.library.repository.dto.AuthorDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
interface AuthorMapper {

    Author authorDtoToAuthor(AuthorDto authorDto);

    AuthorDto authorToAuthorDto(Author author);

}

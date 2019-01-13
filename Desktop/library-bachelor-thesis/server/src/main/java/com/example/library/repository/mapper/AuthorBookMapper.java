package com.example.library.repository.mapper;


import com.example.library.model.AuthorBook;
import com.example.library.repository.dto.AuthorBookDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
interface AuthorBookMapper {

    AuthorBook authorBookDtoToAuthorBook(AuthorBookDto authorbookDto);

    AuthorBookDto authorBookToAuthorBookDto(AuthorBook authorBook);

}

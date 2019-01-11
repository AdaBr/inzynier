package com.example.library.authorbook;


import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
interface AuthorBookMapper {

    AuthorBook authorBookDtoToAuthorBook(AuthorBookDto authorbookDto);

    AuthorBookDto authorBookToAuthorBookDto(AuthorBook authorBook);

}

package com.example.library.book;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface BookMapper {

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}

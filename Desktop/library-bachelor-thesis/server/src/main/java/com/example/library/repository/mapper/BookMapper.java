package com.example.library.repository.mapper;

import com.example.library.model.Book;
import com.example.library.repository.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}

package com.example.library.repository.mapper;

import com.example.library.model.Book;
import com.example.library.repository.dto.BookDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapperImpl implements BookMapper {

    @Autowired
    private BookMapper delegate;


    @Override
    public BookDto bookToBookDto(Book book) {
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto, "category", "authorsNames");
        bookDto.setId(book.getId());
        return bookDto;
    }


    @Override
        public Book bookDtoToBook(BookDto bookDto) {

        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book, "category", "authorsNames");

        return book;
    }

    public List<BookDto> booksToBookDtos(List<Book> bookList) {
        List<BookDto> bookDtoList = new ArrayList<>();
        bookList.stream().forEach(book -> bookDtoList.add(bookToBookDto(book)));
        return bookDtoList;
    }

    List<Book> bookDtosToBookList(List<BookDto> bookDtoList) {
        List<Book> bookList = new ArrayList<>();
        bookDtoList.stream().forEach(bookDto -> bookList.add(bookDtoToBook(bookDto)));
        return bookList;
    }
}


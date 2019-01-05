package com.example.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class BookMapperDecorator implements BookMapper {

    @Autowired
    private BookMapper delegate;

    @Override
    public BookDto bookToBookDto(Book book) {
        BookDto bookDto = delegate.bookToBookDto(book);
        bookDto.setTitle(book.getTitle());
        bookDto.setTitle(book.getTitle());
        return bookDto;
    }

    //to bybły new String  book.setTitle(new String(bookDto.getTitle()));
    @Override
    public Book bookDtoToBook(BookDto bookDto) {
        Book book = delegate.bookDtoToBook(bookDto);
        book.setTitle(bookDto.getTitle());
        book.setTitle(bookDto.getTitle());
        return book;
    }

    List<BookDto> booksToBookDtos(List<Book> bookList) {
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


package com.example.library.service.facade;

import com.example.library.model.Book;
import com.example.library.repository.dto.BookDto;
import com.example.library.repository.mapper.BookMapperImpl;
import com.example.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookFacade {

    @Autowired
    private BookCommandService bookCommandService;

    @Autowired
    private BookQueryService bookQueryService;

    @Autowired
    private BookSearchService bookSearchService;

    @Autowired
    private AuthorBookService authorBookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookMapperImpl mapper;


    public void addBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        bookCommandService.addBook(book);
    }

    public void modifyBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        bookCommandService.modifyBook(book);
    }

    public BookDto getBook(Long id) {
        return setBookDtoAuthorsNames(id);
    }

    public BookDto getBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        return mapper.bookToBookDto(bookQueryService.getBook(book));
    }

    public void removeBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        bookCommandService.removeBook(book);
    }

    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : bookQueryService.getAllBooks()) {
            bookDtoList.add(setBookDtoAuthorsNames(book.getId()));
        }
        return bookDtoList;
    }

    public void removeAllBooks() {
        bookCommandService.removeAllBooks();
    }


    public List<BookDto> getBooksBySearch(String search) {
        return mapper.booksToBookDtos(bookSearchService.getBookBySearch(search));
    }

    public List<BookDto> getBookByTitle(String search) {
        return mapper.booksToBookDtos(bookSearchService.getBookByTitle(search));
    }

    public BookDto setBookDtoAuthorsNames(Long id) {
        BookDto bookDto = mapper.bookToBookDto(bookQueryService.getBook(id));
        List<Long> authorsID = authorBookService.getAuthorsIDWithBookID(id);
        bookDto.setAuthorsNames(authorService.authorsName(authorsID));

        return bookDto;
    }

}



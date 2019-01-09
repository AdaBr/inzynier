package com.example.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private BookMapperDecorator mapper;

    public void addBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        bookCommandService.addBook(book);
    }

    public void modifyBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        bookCommandService.modifyBook(book);
    }

    public BookDto getBook(Long ISBN) {
        return mapper.bookToBookDto(bookQueryService.getBook(ISBN));
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
        return mapper.booksToBookDtos(bookQueryService.getAllBooks());
    }

    public void removeAllBooks() {
        bookCommandService.removeAllBooks();
    }


    public List<BookDto> getBookBySearch(String search) {
        return mapper.booksToBookDtos(bookSearchService.getBookBySearch(search));
    }

    public List<BookDto> getBookByTitle(String search) {
        return mapper.booksToBookDtos(bookSearchService.getBookByTitle(search));
    }
}



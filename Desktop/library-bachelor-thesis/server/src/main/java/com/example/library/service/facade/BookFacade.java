package com.example.library.service.facade;

import com.example.library.model.AuthorBook;
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
    private BookService bookService;

    @Autowired
    private AuthorBookService authorBookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookMapperImpl mapper;



    public BookDto getBook(Long id) {
        return setBookDtoAuthorsNames(id);
    }

    public BookDto getBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        return mapper.bookToBookDto(bookService.getBook(book));
    }


    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : bookService.getAllBooks()) {
            bookDtoList.add(setBookDtoAuthorsNames(book.getId()));
        }
        return bookDtoList;
    }


    public List<BookDto> getBooksBySearch(String search) {
        if (search.equals("")) {
            return getAllBooks();
        }
        else {
            List<BookDto> bookDtoList = new ArrayList<>();
            for (Book book : bookService.getBookBySearch(search)) {
                bookDtoList.add(setBookDtoAuthorsNames(book.getId()));
            }
            return bookDtoList;
        }
    }

    public List<BookDto> getBookByTitle(String search) {
        return mapper.booksToBookDtos(bookService.getBookByTitle(search));
    }

    public BookDto setBookDtoAuthorsNames(Long id) {
        BookDto bookDto = mapper.bookToBookDto(bookService.getBook(id));
        List<Long> authorsID = new ArrayList<>();
        for (AuthorBook authorBook : authorBookService.getAuthorsIDWithBookID(id)) {
            authorsID.add(authorBook.getAuthorBookIdentity().getAuthorID());
        }
        bookDto.setAuthorsNames(authorService.authorsName(authorsID));

        return bookDto;
    }


    /*
    public void addBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        bookCommandService.addBook(book);
    }

    public void modifyBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        bookCommandService.modifyBook(book);
    }

    public void removeAllBooks() {
        bookCommandService.removeAllBooks();
    }

    public void removeBook(BookDto bookDto) {
        Book book = mapper.bookDtoToBook(bookDto);
        bookCommandService.removeBook(book);
    }




    */

}



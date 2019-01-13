package com.example.library.service.facade;

import com.example.library.model.AuthorBook;
import com.example.library.model.UserBook;
import com.example.library.repository.dto.UserBookDto;
import com.example.library.repository.mapper.UserBookMapperImpl;
import com.example.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBookFacade {

    @Autowired
    private UserBookService userBookService;

    @Autowired
    private BookSearchService bookService;

    @Autowired
    private AuthorBookService authorBookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserBookMapperImpl mapper;


    public List<UserBookDto> getAllUserBooks(Long userID) {

        List<UserBookDto> userBookDtoList = new ArrayList<>();
        for (UserBook userBook : userBookService.getAllUserBooks(userID)) {
            userBookDtoList.add(setUserBookDtoDetails(userBook));
        }
        return userBookDtoList;
    }

    public List<UserBookDto> getUserBooksWithStatus(Long userID, String chosenStatus) {

        List<UserBookDto> userBookDtoList = new ArrayList<>();
        for (UserBook userBook : userBookService.getUserBooksWithStatus(userID, chosenStatus)) {
            userBookDtoList.add(setUserBookDtoDetails(userBook));
        }
        return userBookDtoList;
    }

    public UserBookDto setUserBookDtoDetails(UserBook userBook) {
        UserBookDto userBookDto = mapper.userBookToUserBookDto(userBook);
        userBookDto.setBookTitle(bookService.getBookTitle(userBook.getUserBookIdentity().getBookID()));

        List<Long> authorsID = authorBookService.getAuthorsIDWithBookID(userBook.getUserBookIdentity().getBookID());
        userBookDto.setBookAuthors(authorService.authorsName(authorsID));

        return userBookDto;
    }
}

package com.example.library.service.facade;

import com.example.library.model.AuthorBook;
import com.example.library.model.Basket;
import com.example.library.model.BasketBook;
import com.example.library.model.Favorite;
import com.example.library.repository.dto.BasketBookDto;
import com.example.library.repository.dto.FavoriteDto;
import com.example.library.repository.mapper.BasketBookMapperImpl;
import com.example.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketBookFacade {

    @Autowired
    private BasketBookService basketBookService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorBookService authorBookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BasketBookMapperImpl mapper;



    public List<BasketBookDto> getBooksFromBasketBook(Long basketID) {

        List<BasketBookDto> basketBookDtoList = new ArrayList<>();
        for (BasketBook basketBook : basketBookService.getBasketBooksFromBasket(basketID)) {
            basketBookDtoList.add(setBasketBookDtoDetails(basketBook));
        }
        return basketBookDtoList;
    }



    private BasketBookDto setBasketBookDtoDetails(BasketBook basketBook) {
        BasketBookDto basketBookDto=mapper.basketBookToBasketBookDto(basketBook);

        basketBookDto.setBookTitle(bookService.getBookTitle(basketBook.getBasketBookIdentity().getBookID()));
        basketBookDto.setBookCover(bookService.getBookCover(basketBook.getBasketBookIdentity().getBookID()));
        basketBookDto.setPrice(bookService.getBookPrice(basketBook.getBasketBookIdentity().getBookID()));

        List<Long> authorsID = new ArrayList<>();
        for (AuthorBook authorBook : authorBookService.getAuthorsIDWithBookID(basketBook.getBasketBookIdentity().getBookID())) {
            authorsID.add(authorBook.getAuthorBookIdentity().getAuthorID());
        }
        basketBookDto.setBookAuthors(authorService.authorsName(authorsID));


        return basketBookDto;
    }


    public boolean addBookToBasketBook(BasketBookDto basketBookDto) {

        List<Basket> basketList=basketService.getUserBasketWithStatus(basketBookDto.getUserID(), "WAITING");

        if (basketList.isEmpty()){
            Basket basket= new Basket();
            basket.setUserID(basketBookDto.getUserID());
            basket.setStatus("WAITING");
            basketService.addBasketToUser(basket);
            basketBookDto.setBasketID(basket.getBasketID());
        }
        basketBookDto.setBasketID(basketList.get(0).getBasketID());
        BasketBook basketBook = mapper.basketBookDtoToBasketBook(basketBookDto);

        return basketBookService.addBookToBasektBook(basketBook);
    }

    public boolean removeBookFromBasketBook(BasketBookDto basketBookDto) {
        BasketBook basketBook = mapper.basketBookDtoToBasketBook(basketBookDto);

        return basketBookService.removeBookFromBasketBook(basketBook);
    }

    public List<BasketBookDto> getBooksFromUserBasketWithStatus(Long userID, String status) {
        List<BasketBookDto> basketBookDtoList = new ArrayList<>();
        for (BasketBook basketBook : basketBookService.getBasketBooksFromUserBasket(userID, status)) {
            basketBookDtoList.add(setBasketBookDtoDetails(basketBook));
        }
        return basketBookDtoList;
    }
}

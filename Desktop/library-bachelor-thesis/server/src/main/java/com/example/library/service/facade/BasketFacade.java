package com.example.library.service.facade;

import com.example.library.model.AuthorBook;
import com.example.library.model.Basket;
import com.example.library.model.UserBook;
import com.example.library.repository.dto.BasketDto;
import com.example.library.repository.dto.UserBookDto;
import com.example.library.repository.mapper.BasketMapperImpl;
import com.example.library.repository.mapper.UserBookMapperImpl;
import com.example.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketFacade {

    @Autowired
    private BasketService basketService;

    @Autowired
    private BasketBookService basketBookService;

    @Autowired
    private BookService bookService;


    @Autowired
    private BasketMapperImpl mapper;


    public List<BasketDto> getAllUserBasket(Long userID) {
        List<BasketDto> basketDtoList = new ArrayList<>();
        for (Basket basket: basketService.getAllUserBaskets(userID)) {
            basketDtoList.add(setBasketDtoDetails(basket));
        }
        return basketDtoList;
    }

    public List<BasketDto> getUserBasketWithStatus(Long userID, String status) {
        List<BasketDto> basketDtoList = new ArrayList<>();
        for (Basket basket: basketService.getUserBasketWithStatus(userID, status)) {
            basketDtoList.add(setBasketDtoDetails(basket));
        }
        return basketDtoList;
    }


    public BasketDto setBasketDtoDetails(Basket basket) {
        BasketDto basketDto= mapper.basketToBasketDto(basket);

        float amount=0;
        for (Long bookID : basketBookService.getBooksFromBasketBook(basket.getBasketID())) {
            amount+=bookService.getBookPrice(bookID);
        }
        basketDto.setWholeAmount(amount);

        return basketDto;
    }

    public boolean addBasketToUser(BasketDto basketDto) {

        return basketService.addBasketToUser(mapper.basketDtoToBasket(basketDto));
    }

    public boolean modifyBasket(BasketDto basketDto) {

        return basketService.modifyBasket(mapper.basketDtoToBasket(basketDto));
    }
}

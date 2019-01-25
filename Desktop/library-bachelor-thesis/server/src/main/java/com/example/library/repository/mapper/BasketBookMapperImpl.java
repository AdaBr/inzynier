package com.example.library.repository.mapper;

import com.example.library.model.BasketBook;
import com.example.library.model.extensions.BasketBookIdentity;
import com.example.library.repository.dto.BasketBookDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BasketBookMapperImpl implements BasketBookMapper{


    @Override
    public BasketBook basketBookDtoToBasketBook(BasketBookDto basketBookDto) {
        BasketBook basketBook = new BasketBook();
        BasketBookIdentity basketBookIdentity= new BasketBookIdentity(basketBookDto.getBasketID(), basketBookDto.getBookID());
        basketBook.setBasketBookIdentity(basketBookIdentity);
        basketBook.setUserID(basketBookDto.getUserID());
        return basketBook;
    }

    @Override
    public BasketBookDto basketBookToBasketBookDto(BasketBook basketBook) {
        BasketBookDto basketBookDto = new BasketBookDto();
        basketBookDto.setUserID(basketBook.getUserID());
        basketBookDto.setBasketID(basketBook.getBasketBookIdentity().getBasketID());
        basketBookDto.setBookID(basketBook.getBasketBookIdentity().getBookID());
        return basketBookDto;
    }

    public List<BasketBookDto> basketBooksToBasketBookDtos(List<BasketBook> basketBookList) {
        List<BasketBookDto> basketBookDtoList = new ArrayList<>();
        basketBookList.stream().forEach(basketBook -> basketBookDtoList.add(basketBookToBasketBookDto(basketBook)));
        return basketBookDtoList;
    }

    List<BasketBook> basketBookDtosToBasketBooks(List<BasketBookDto> basketBookDtoList) {
        List<BasketBook> basketBookList= new ArrayList<>();
        basketBookDtoList.stream().forEach(basketBookDto -> basketBookList.add(basketBookDtoToBasketBook(basketBookDto)));
        return basketBookList;
    }
}

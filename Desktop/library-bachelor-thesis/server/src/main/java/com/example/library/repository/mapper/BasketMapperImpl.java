package com.example.library.repository.mapper;

import com.example.library.model.Basket;
import com.example.library.model.Book;
import com.example.library.model.extensions.UserBasketIdentity;
import com.example.library.repository.dto.BasketDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BasketMapperImpl implements BasketMapper{


    @Override
    public Basket basketDtoToBasket(BasketDto basketDto) {
        Basket basket = new Basket();
        basket.setUserID(basketDto.getUserID());
        basket.setBasketID(basketDto.getBasketID());
        basket.setStatus(basketDto.getStatus());
        basket.setRealizationDate(basket.getRealizationDate());
        return basket;
    }

    @Override
    public BasketDto basketToBasketDto(Basket basket) {
        BasketDto basketDto = new BasketDto();
        basketDto.setUserID(basket.getUserID());
        basketDto.setBasketID(basket.getBasketID());
        basketDto.setStatus(basket.getStatus());
        basketDto.setRealizationDate(basket.getRealizationDate());
        return basketDto;
    }

    public List<BasketDto> basketsToBasketDtos(List<Basket> basketList) {
        List<BasketDto> basketDtoList = new ArrayList<>();
        basketList.stream().forEach(basket -> basketDtoList.add(basketToBasketDto(basket)));
        return basketDtoList;
    }

    List<Basket> basketDtosToBaskets(List<BasketDto> basketDtoList) {
        List<Basket> basketList= new ArrayList<>();
        basketDtoList.stream().forEach(basketDto -> basketList.add(basketDtoToBasket(basketDto)));
        return basketList;
    }
}

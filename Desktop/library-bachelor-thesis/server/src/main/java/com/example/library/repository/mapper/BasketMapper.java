package com.example.library.repository.mapper;

import com.example.library.model.Basket;
import com.example.library.model.UserBook;
import com.example.library.repository.dto.BasketDto;
import com.example.library.repository.dto.UserBookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasketMapper {

    Basket basketDtoToBasket(BasketDto basketDto);

    BasketDto basketToBasketDto(Basket basket);


}

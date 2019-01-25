package com.example.library.repository.mapper;


import com.example.library.model.BasketBook;
import com.example.library.repository.dto.BasketBookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasketBookMapper {

    BasketBook basketBookDtoToBasketBook(BasketBookDto basketBookDto);

    BasketBookDto basketBookToBasketBookDto(BasketBook basketBook);


}

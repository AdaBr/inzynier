package com.example.library.repository.mapper;

import com.example.library.model.UserBook;
import com.example.library.repository.dto.UserBookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserBookMapper {

    UserBook userBookDtoToUserBook (UserBookDto userBookDto);

    UserBookDto userBookToUserBookDto (UserBook userBook);


}

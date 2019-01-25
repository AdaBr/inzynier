package com.example.library.repository.mapper;


import com.example.library.model.AuthorBook;
import com.example.library.model.Favorite;
import com.example.library.repository.dto.AuthorBookDto;
import com.example.library.repository.dto.FavoriteDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
interface FavoriteMapper {

    Favorite favoriteDtoToFavorite(FavoriteDto favoriteDto);

    FavoriteDto favoriteToFavoriteDto(Favorite favorite);

}

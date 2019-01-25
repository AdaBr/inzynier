package com.example.library.repository.mapper;

import com.example.library.model.Favorite;
import com.example.library.model.extensions.UserBookIdentity;
import com.example.library.repository.dto.FavoriteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FavoriteMapperImpl implements FavoriteMapper {

    @Autowired
    private FavoriteMapper delegate;


    @Override
    public FavoriteDto favoriteToFavoriteDto(Favorite favorite) {
        FavoriteDto favoriteDto = new FavoriteDto();
        favoriteDto.setUserID(favorite.getUserBookIdentity().getUserID());
        favoriteDto.setBookID(favorite.getUserBookIdentity().getBookID());
        return favoriteDto;
    }

    @Override
    public Favorite favoriteDtoToFavorite(FavoriteDto favoriteDto) {
        Favorite favorite=new Favorite();
        UserBookIdentity favoriteIdentity = new UserBookIdentity(favoriteDto.getUserID(), favoriteDto.getBookID());
        favorite.setUserBookIdentity(favoriteIdentity);
        return favorite;
    }

    public List<FavoriteDto> favoritesToFavoriteDtos(List<Favorite> favoriteList) {
        List<FavoriteDto> favoriteDtoList = new ArrayList<>();
        favoriteList.stream().forEach(favorite -> favoriteDtoList.add(favoriteToFavoriteDto(favorite)));
        return favoriteDtoList;
    }

    List<Favorite> favoriteDtosToFavoriteList(List<FavoriteDto> userDtoList) {
        List<Favorite> favoriteList = new ArrayList<>();
        userDtoList.stream().forEach(favoriteDto -> favoriteList.add(favoriteDtoToFavorite(favoriteDto)));
        return favoriteList;
    }
}

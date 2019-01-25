package com.example.library.service.facade;

import com.example.library.model.AuthorBook;
import com.example.library.model.Favorite;
import com.example.library.repository.dto.FavoriteDto;
import com.example.library.repository.mapper.FavoriteMapperImpl;
import com.example.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteFacade {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorBookService authorBookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private FavoriteMapperImpl mapper;


    public List<FavoriteDto> getAllFavorites(Long userID) {

        List<FavoriteDto> favoriteDtoList = new ArrayList<>();
        for (Favorite favorite : favoriteService.getAllFavorites(userID)) {
            favoriteDtoList.add(setFavoriteDtoDetails(favorite));
        }
        return favoriteDtoList;
    }


    public FavoriteDto setFavoriteDtoDetails(Favorite favorite) {
        FavoriteDto favoriteDto = mapper.favoriteToFavoriteDto(favorite);

        favoriteDto.setBookTitle(bookService.getBookTitle(favorite.getUserBookIdentity().getBookID()));
        favoriteDto.setCoverOfBook(bookService.getBookCover(favorite.getUserBookIdentity().getBookID()));
        favoriteDto.setPrice(bookService.getBookPrice(favorite.getUserBookIdentity().getBookID()));

        List<Long> authorsID = new ArrayList<>();
        for (AuthorBook authorBook : authorBookService.getAuthorsIDWithBookID(favorite.getUserBookIdentity().getBookID())) {
            authorsID.add(authorBook.getAuthorBookIdentity().getAuthorID());
        }
        favoriteDto.setBookAuthors(authorService.authorsName(authorsID));

        return favoriteDto;
    }

    public boolean addBookToFavorites(FavoriteDto favoriteDto) {
        Favorite favorite = mapper.favoriteDtoToFavorite(favoriteDto);

        return favoriteService.addBookToFavorites(favorite);
    }

    public boolean removeBookFromFavorites(FavoriteDto favoriteDto) {
        Favorite favorite = mapper.favoriteDtoToFavorite(favoriteDto);

        return favoriteService.deleteBookFromFavorites(favorite);
    }
}

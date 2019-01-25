package com.example.library.api;

import com.example.library.repository.dto.FavoriteDto;
import com.example.library.service.facade.FavoriteFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("favorites")
public class FavoriteEndpoint {

    @Autowired
    private FavoriteFacade favoriteFacade;


    @RequestMapping(value = "{userID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllUserFavoriteBooks(@PathVariable("userID") Long userID) {
        return new ResponseEntity<>(favoriteFacade.getAllFavorites(userID), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> addBookToFavorites(@RequestBody FavoriteDto favoriteDto) {
       if (favoriteFacade.addBookToFavorites(favoriteDto)) {
           return new ResponseEntity<>(favoriteDto, HttpStatus.OK);
       }
        return new ResponseEntity<>(favoriteDto, HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> modifyBookFromFavorites(@RequestBody FavoriteDto favoriteDto) {
        if (favoriteFacade.removeBookFromFavorites(favoriteDto)) {
            return new ResponseEntity<> (favoriteDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(favoriteDto, HttpStatus.NOT_FOUND);
        }
    }


}

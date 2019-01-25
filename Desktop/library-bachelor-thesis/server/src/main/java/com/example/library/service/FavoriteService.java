package com.example.library.service;

import com.example.library.model.Favorite;
import com.example.library.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    
    @Autowired
    private FavoriteRepository favoriteRepository;
    
    
    public List<Favorite> getAllFavorites(Long userID) {
        return favoriteRepository.findByUserBookIdentity_UserID(userID);
    }


    public boolean addBookToFavorites(Favorite favorite) {

        Favorite alreadyExist = favoriteRepository.findByUserBookIdentity(favorite.getUserBookIdentity());
        if (alreadyExist!=null){
            return false;
        }
        else {
            favoriteRepository.save(favorite);
            return true;
        }
    }


    public boolean deleteBookFromFavorites(Favorite favorite) {
        Favorite alreadyExist = favoriteRepository.findByUserBookIdentity(favorite.getUserBookIdentity());
        if (alreadyExist!=null){
            favoriteRepository.delete(favorite);
            return true;
        }
        else {
            return false;
        }
    }
}

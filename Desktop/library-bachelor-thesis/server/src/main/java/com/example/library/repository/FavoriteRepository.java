package com.example.library.repository;

import com.example.library.model.Favorite;
import com.example.library.model.extensions.UserBookIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, UserBookIdentity> {
    List<Favorite> findByUserBookIdentity_UserID(Long userID);
    List<Favorite> findByUserBookIdentity_BookID(Long bookID);
    Favorite findByUserBookIdentity(UserBookIdentity userBookIdentity);

}

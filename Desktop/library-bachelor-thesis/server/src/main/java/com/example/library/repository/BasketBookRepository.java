package com.example.library.repository;


import com.example.library.model.BasketBook;
import com.example.library.model.extensions.BasketBookIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketBookRepository extends JpaRepository<BasketBook, BasketBookIdentity> {

    BasketBook findByBasketBookIdentity(BasketBookIdentity basketBookIdentity);
    List<BasketBook> findByBasketBookIdentity_BasketID(Long basketID);
    List<BasketBook> findByBasketBookIdentity_BookID(Long bookID);
    List<BasketBook> findByUserID(Long userID);
    List<BasketBook> findByBasketBookIdentity_BookIDAndUserID(Long bookID, Long userID);



}

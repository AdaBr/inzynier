package com.example.library.repository;

import com.example.library.model.Basket;
import com.example.library.model.extensions.UserBasketIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Basket findByBasketID(Long basketID);
    List<Basket> findByUserID(Long userID);
    List<Basket> findByUserIDAndStatus(Long userID, String status);
}

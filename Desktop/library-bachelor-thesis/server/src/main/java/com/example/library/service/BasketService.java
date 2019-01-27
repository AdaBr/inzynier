package com.example.library.service;

import com.example.library.model.Basket;
import com.example.library.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    
    @Autowired
    private BasketRepository basketRepository;
    
    
    public List<Basket> getAllUserBaskets(Long userID) {
        return basketRepository.findByUserID(userID);

    }

    public List<Basket> getUserBasketWithStatus(Long userID, String status) {
        return basketRepository.findByUserIDAndStatus(userID, status);
    }

    public boolean addBasketToUser(Basket basket) {
        List<Basket> alredyExsist = basketRepository.findByUserIDAndStatus(basket.getUserID(), "WAITING");
        if (alredyExsist.isEmpty()) {
            basket.setStatus("WAITING");
            addBasket(basket);
            return true;
        }
        else if (alredyExsist.get(0).getStatus()!="WAITING") {
            basket.setStatus("WAITING");
            addBasket(basket);
            return true;
        }
        return false;
    }

    private void addBasket(Basket basket) {
        basketRepository.save(basket);
    }



    public boolean modifyBasket(Basket basket) {

        Basket alreadyExsist= basketRepository.findByBasketID(basket.getBasketID());
        if (alreadyExsist!=null) {
            alreadyExsist.setStatus(basket.getStatus());
            alreadyExsist.setRealizationDate(basket.getRealizationDate());
            addBasketToUser(new Basket(basket.getUserID()));
            return true;
        }

        return false;
    }


}

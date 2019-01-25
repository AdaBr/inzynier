package com.example.library.service;


import com.example.library.model.Basket;
import com.example.library.model.BasketBook;
import com.example.library.repository.BasketBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketBookService {
    
    @Autowired
    private BasketBookRepository basketBookRepository;

    @Autowired
    private BasketService basketService;
    
    
    public List<BasketBook> getBasketBooksFromBasket(Long basketID) {
        return basketBookRepository.findByBasketBookIdentity_BasketID(basketID);

    }

    public boolean addBookToBasektBook(BasketBook basketBook) {
        BasketBook alredyExsist = basketBookRepository.findByBasketBookIdentity(basketBook.getBasketBookIdentity());
        if (alredyExsist==null) {
            addBasketBook(basketBook);
            return true;
        }
        return false;
    }

    private void addBasketBook(BasketBook basketBook) {
        basketBookRepository.save(basketBook);
    }


    public boolean removeBookFromBasketBook(BasketBook basketBook) {

        BasketBook alredyExsist = basketBookRepository.findByBasketBookIdentity(basketBook.getBasketBookIdentity());
        if (alredyExsist!=null) {
            removeBasketBook(basketBook);
            return true;
        }
        return false;

    }

    private void removeBasketBook(BasketBook basketBook) {
        basketBookRepository.delete(basketBook);
    }


    public List<Long> getBooksFromBasketBook(Long basketID) {

        List<Long> booksID= new ArrayList<>();
        for (BasketBook basketBook : getBasketBooksFromBasket(basketID)) {
            booksID.add(basketBook.getBasketBookIdentity().getBookID());
        }
        return booksID;
    }


    public List<BasketBook> getBasketBooksFromUserBasket(Long userID, String status) {

        List<Basket> basketBookList = basketService.getUserBasketWithStatus(userID, status);
        return getBasketBooksFromBasket(basketBookList.get(0).getBasketID());

    }
}

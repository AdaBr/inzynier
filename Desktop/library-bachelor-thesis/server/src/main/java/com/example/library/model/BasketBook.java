package com.example.library.model;


import com.example.library.model.extensions.BasketBookIdentity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "basketbook")
public class BasketBook {

    @EmbeddedId
    private BasketBookIdentity basketBookIdentity;

    @Column(name = "user_id")
    private Long userID;

    public BasketBook() {

    }

    public BasketBook(BasketBookIdentity basketBookIdentity, Long userID) {
        this.basketBookIdentity = basketBookIdentity;
        this.userID = userID;
    }


    public BasketBookIdentity getBasketBookIdentity() {
        return basketBookIdentity;
    }

    public void setBasketBookIdentity(BasketBookIdentity basketBookIdentity) {
        this.basketBookIdentity = basketBookIdentity;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}

package com.example.library.model.extensions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class BasketBookIdentity implements Serializable {

    @Column(name = "basket_id")
    @NotNull
    private Long basketID;


    @Column(name = "book_id")
    @NotNull
    private Long bookID;


    public BasketBookIdentity() {

    }

    public BasketBookIdentity(@NotNull Long basketID, @NotNull Long bookID) {
        this.basketID = basketID;
        this.bookID = bookID;
    }


    public Long getBasketID() {
        return basketID;
    }

    public void setBasketID(Long basketID) {
        this.basketID = basketID;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

}

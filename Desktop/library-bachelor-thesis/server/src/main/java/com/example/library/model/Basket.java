package com.example.library.model;

import com.example.library.model.extensions.UserBasketIdentity;
import com.example.library.model.extensions.UserBookIdentity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "basket_id")
    private Long basketID;

    @Column(name = "user_id")
    private Long userID;

    private String status;

    @Column(name = "realization_date")
    private Date realizationDate;

    public Basket(Long userID) {
        this.userID=userID;
    }

    public Basket() {

    }

    public Long getBasketID() {
        return basketID;
    }

    public void setBasketID(Long basketID) {
        this.basketID = basketID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(Date realizationDate) {
        this.realizationDate = realizationDate;
    }
}

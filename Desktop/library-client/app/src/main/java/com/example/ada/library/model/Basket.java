package com.example.ada.library.model;

import java.util.Date;

/**
 * Created by ada on 22.01.2019.
 */

public class Basket {
    private Long userID;

    private Long basketID;

    private String status;

    private Date realizationDate;

    private float wholeAmount;

    public float getWholeAmount() {
        return wholeAmount;
    }

    public void setWholeAmount(float wholeAmount) {
        this.wholeAmount = wholeAmount;
    }

    public Date getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(Date realizationDate) {
        this.realizationDate = realizationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}

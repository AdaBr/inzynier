package com.example.library.repository.dto;

import java.util.Date;


public class BasketDto {

    private Long userID;

    private Long basketID;

    private String status;

    private Date realizationDate;

    private float wholeAmount;


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getBasketID() {
        return basketID;
    }

    public void setBasketID(Long basketID) {
        this.basketID = basketID;
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

    public float getWholeAmount() {
        return wholeAmount;
    }

    public void setWholeAmount(float wholeAmount) {
        this.wholeAmount = wholeAmount;
    }
}

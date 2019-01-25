package com.example.ada.library.model;

/**
 * Created by ada on 22.01.2019.
 */

public class BasketBook {

    private Long basketID;

    private Long bookID;

    private Long userID;

    private String bookTitle;

    private String bookAuthors;

    private String bookCover;

    private Float price;

    public BasketBook() {

    }

    public BasketBook(Long userID, Long bookID) {
        this.userID=userID;
        this.bookID=bookID;
    }

    public BasketBook(Long basketID, Long bookID, Long userID) {
        this.basketID=basketID;
        this.bookID=bookID;
        this.userID=userID;
    }


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public Long getBasketID() {
        return basketID;
    }

    public void setBasketID(Long basketID) {
        this.basketID = basketID;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(String bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}

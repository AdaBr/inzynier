package com.example.ada.library.model;

/**
 * Created by ada on 19.01.2019.
 */

public class Favorite {

    private Long userID;

    private Long bookID;

    private String bookTitle;

    private String bookAuthors;

    private String coverOfBook;

    private Float price;

    public Favorite(Long userID, Long bookID) {
        this.userID = userID;
        this.bookID = bookID;
    }


    public Long getUserID() {
        return userID;
    }

    public Long getBookID() {
        return bookID;
    }


    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthors() {
        return bookAuthors;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthors(String bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public String getCoverOfBook() {
        return coverOfBook;
    }

    public void setCoverOfBook(String coverOfBook) {
        this.coverOfBook = coverOfBook;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}


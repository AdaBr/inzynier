package com.example.ada.library.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by ada on 17.01.2019.
 */

public class UserBook {

    private Long userID;

    private Long bookID;

    private String status;

    private Date downloadDate;

    private String bookTitle;

    private String bookAuthors;

    @SerializedName("coverOfBook")
    private String photo;

    public UserBook(Long userID, Long bookID, String status, Date downloadDate, String bookTitle, String bookAuthors, String photo) {
        this.userID = userID;
        this.bookID = bookID;
        this.status = status;
        this.downloadDate = downloadDate;
        this.bookTitle = bookTitle;
        this.bookAuthors = bookAuthors;
        this.photo = photo;
    }

    public UserBook(Long userID, Long bookID, String status, Date downloadDate) {
        this.userID = userID;
        this.bookID = bookID;
        this.status = status;
        this.downloadDate = downloadDate;

    }

    public Long getUserID() {
        return userID;
    }

    public Long getBookID() {
        return bookID;
    }

    public String getStatus() {
        return status;
    }

    public Date getDownloadDate() {
        return downloadDate;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthors(String bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

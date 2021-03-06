package com.example.library.repository.dto;

import java.util.Date;

public class UserBookDto {

    private Long userID;

    private Long bookID;

    private String status;

    private Date downloadDate;

    private String bookTitle;

    private String bookAuthors;

    private String coverOfBook;


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

    public String getCoverOfBook() {
        return coverOfBook;
    }

    public void setCoverOfBook(String coverOfBook) {
        this.coverOfBook = coverOfBook;
    }
}

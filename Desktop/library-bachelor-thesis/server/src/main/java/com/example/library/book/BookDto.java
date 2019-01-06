package com.example.library.book;


import java.util.List;

public class BookDto {

    private Long id;

    private String ISBN;

    private String title;

    private List<Long> authorsID;


    public BookDto() {

    }

    public BookDto(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }


    public List<Long> getAuthorsID() {
        return authorsID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorsID(List<Long> authorsID) {
        this.authorsID = authorsID;
    }
}

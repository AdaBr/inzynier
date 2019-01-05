package com.example.library.book;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private Long ISBN;

    private String title;


    public Book() {

    }

    public Book(String title) {
        this.title = title;
    }

    public Long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }
    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

package com.example.library.book;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ISBN;

    private String title;

    @ElementCollection
    private List<Long> authorsID = new ArrayList<>();


    public Book() {

    }

    public Book(String ISBN, String title, List<Long> authorsId) {
        this.title = title;
    }

    Long getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public List<Long> getAuthorsId() {
        return authorsID;
    }

    void setId(Long id) {
        this.id = id;
    }


    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthorsId(List<Long> authorsId) {
        this.authorsID = authorsId;
    }

}

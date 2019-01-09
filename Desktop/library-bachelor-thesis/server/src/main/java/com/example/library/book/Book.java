package com.example.library.book;


import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ISBN;

    private String title;

    @Enumerated
    private Category category;

    //private String adressURLOfResource;

    //@Lob
    //private byte[] image;


    public Book() {

    }

    public Book(Long id, String ISBN, String title) {

        this.id = id;
        this.ISBN = ISBN;
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

    void setId(Long id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

package com.example.library.model;

import com.example.library.book.Category;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ISBN;

    private String DIO;

    private String title;

    private String adressURLOfResource;

    private String addressURLOfPhoto;

    @Enumerated
    private Category category;

    public Book() {

    }

    public Book(Long id, String ISBN, String title) {

        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
    }

    public Book(String ISBN, String DIO, String title, String adressURLOfResource, String addressURLOfPhoto, Category category) {
        this.ISBN = ISBN;
        this.DIO = DIO;
        this.title = title;
        this.adressURLOfResource = adressURLOfResource;
        this.addressURLOfPhoto = addressURLOfPhoto;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getDIO() {
        return DIO;
    }

    public String getTitle() {
        return title;
    }

    public String getAdressURLOfResource() {
        return adressURLOfResource;
    }

    public String getAddressURLOfPhoto() {
        return addressURLOfPhoto;
    }


    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setDIO(String DIO) {
        this.DIO = DIO;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAdressURLOfResource(String adressURLOfResource) {
        this.adressURLOfResource = adressURLOfResource;
    }

    public void setAddressURLOfPhoto(String addressURLOfPhoto) {
        this.addressURLOfPhoto = addressURLOfPhoto;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

package com.example.library.model;

import com.example.library.commons.Category;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ISBN;

    private String DOI;

    private String title;

    @Column(name = "downloaded_address")
    private String downloadedAddress;

    private String photo;

    private String category;

    private String description;

    private Float price;

    public Book() {

    }

    public Book(Long id, String ISBN, String title) {

        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
    }

    public Book(String ISBN, String DOI, String title, String adressURLOfResource, String addressURLOfPhoto, String category, Float price) {
        this.ISBN = ISBN;
        this.DOI = DOI;
        this.title = title;
        this.downloadedAddress = adressURLOfResource;
        this.photo = addressURLOfPhoto;
        this.category = category;
        this.price=price;
    }

    public Long getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getDOI() {
        return DOI;
    }

    public String getTitle() {
        return title;
    }

    public String getDownloadedAddress() {
        return downloadedAddress;
    }

    public String getAddressURLOfPhoto() {
        return photo;
    }


    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDownloadedAddress(String downloadedAddress) {
        this.downloadedAddress = downloadedAddress;
    }

    public void setAddressURLOfPhoto(String addressURLOfPhoto) {
        this.photo = addressURLOfPhoto;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

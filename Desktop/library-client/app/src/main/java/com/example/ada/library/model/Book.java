package com.example.ada.library.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ada on 09.01.2019.
 */

public class Book {

    private Long id;

    @SerializedName("isbn")
    private String ISBN;

    @SerializedName("doi")
    private String DOI;

    private String title;

    private String adressURLOfResource;

    private String addressURLOfPhoto;

    private String authorsNames;

    public Book(Long id, String title, String authors, String isbn) {
        this.id = id;
        this.title = title;
        this.authorsNames = authors;
        this.ISBN = isbn;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdressURLOfResource() {
        return adressURLOfResource;
    }

    public void setAdressURLOfResource(String adressURLOfResource) {
        this.adressURLOfResource = adressURLOfResource;
    }

    public String getAddressURLOfPhoto() {
        return addressURLOfPhoto;
    }

    public void setAddressURLOfPhoto(String addressURLOfPhoto) {
        this.addressURLOfPhoto = addressURLOfPhoto;
    }

    public String getAuthorsNames() {
        return authorsNames;
    }

    public void setAuthorsNames(String authorsNames) {
        this.authorsNames = authorsNames;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;

    public Long getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }


}

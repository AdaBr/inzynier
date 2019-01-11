package com.example.ada.library.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ada on 09.01.2019.
 */

public class Book {

    private Long id;

    @SerializedName("isbn")
    private String ISBN;

    private String title;

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

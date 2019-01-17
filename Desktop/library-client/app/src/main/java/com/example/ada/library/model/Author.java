package com.example.ada.library.model;

/**
 * Created by ada on 10.01.2019.
 */

public class Author {

    private Long id;

    private  String surname;

    private String forename;

    public Author() {

    }

    Author(String surname, String forename) {

        this.surname = surname;
        this.forename = forename;
    }

    Author(Long id, String surname, String forename) {
        this.id = id;
        this.surname = surname;
        this.forename = forename;
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getForename() {
        return forename;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }
}

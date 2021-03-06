package com.example.library.model;

import com.example.library.model.extensions.Forename;
import com.example.library.model.extensions.Surname;

import javax.persistence.*;

@Entity
@Table (name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Surname surname;

    @Embedded
    private Forename forename;

    public Author() {

    }

    public Author(Long id, Surname surname, Forename forename) {
        this.id = id;
        this.surname = surname;
        this.forename = forename;
    }

    public Long getId() {
        return id;
    }

    public Surname getSurname() {
        return surname;
    }

    public Forename getForename() {
        return forename;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }

    public void setForename(Forename forename) {
        this.forename = forename;
    }


}

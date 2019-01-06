package com.example.library.author;

import javax.persistence.*;

@Entity
class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Surname surname;

    @Embedded
    private Forename forename;

    Author() {

    }

    Author(Long id, Surname surname, Forename forename) {
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

package com.example.library.AuthorBook;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class AuthorBook {
    

    @EmbeddedId
    private AuthorBookIdentity authorBookIdentity;




}

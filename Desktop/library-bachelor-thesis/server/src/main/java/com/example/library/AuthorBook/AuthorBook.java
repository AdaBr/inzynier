package com.example.library.authorbook;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "authorbook")
public class AuthorBook {


    @EmbeddedId
    private AuthorBookIdentity authorBookIdentity;

    public AuthorBookIdentity getAuthorBookIdentity() {
        return authorBookIdentity;
    }

    public void setAuthorBookIdentity(AuthorBookIdentity authorBookIdentity) {
        this.authorBookIdentity = authorBookIdentity;
    }


}

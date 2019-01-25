package com.example.library.model;


import com.example.library.model.extensions.UserBookIdentity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "favorite")
public class Favorite {

    @EmbeddedId
    private UserBookIdentity userBookIdentity;

    public UserBookIdentity getUserBookIdentity() {
        return userBookIdentity;
    }

    public void setUserBookIdentity(UserBookIdentity userBookIdentity) {
        this.userBookIdentity = userBookIdentity;
    }

}

package com.example.library.model;


import com.example.library.model.extensions.Status;
import com.example.library.model.extensions.UserBookIdentity;

import javax.persistence.*;

@Entity
@Table(name = "userbook")
public class UserBook {

    @EmbeddedId
    private UserBookIdentity userBookIdentity;

    @Enumerated
    private Status status;

    private int downloadDate;

    public UserBookIdentity getUserBookIdentity() {
        return userBookIdentity;
    }

    public String getStatus() {
        return status.toString();
    }

    public int getDownloadDate() {
        return downloadDate;
    }

    public void setUserBookIdentity(UserBookIdentity userBookIdentity) {
        this.userBookIdentity = userBookIdentity;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDownloadDate(int downloadDate) {
        this.downloadDate = downloadDate;
    }
}

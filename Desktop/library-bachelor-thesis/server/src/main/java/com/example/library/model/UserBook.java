package com.example.library.model;


import com.example.library.model.extensions.Status;
import com.example.library.model.extensions.UserBookIdentity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "userbook")
public class UserBook {

    @EmbeddedId
    private UserBookIdentity userBookIdentity;

    private String status;

    @Column(name = "download_date")
    private Date downloadDate;

    public UserBookIdentity getUserBookIdentity() {
        return userBookIdentity;
    }

    public String getStatus() {
        return status;
    }

    public String getStringStatus() {
        return status.toString();
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setUserBookIdentity(UserBookIdentity userBookIdentity) {
        this.userBookIdentity = userBookIdentity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }
}

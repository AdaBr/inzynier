package com.example.library.model.extensions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserBookIdentity implements Serializable {

    @Column(name = "user_id")
    @NotNull
    private Long userID;

    @Column(name = "book_id")
    @NotNull
    private Long bookID;

    public UserBookIdentity() {

    }

    public UserBookIdentity(Long userID, Long bookID) {

        this.userID = userID;
        this.bookID = bookID;
    }

    public Long getBookID() {
        return bookID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBookIdentity)) return false;
        UserBookIdentity that = (UserBookIdentity) o;
        return Objects.equals(getUserID(),that.getUserID())
                && Objects.equals(getBookID(), that.getBookID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getBookID());
    }


}

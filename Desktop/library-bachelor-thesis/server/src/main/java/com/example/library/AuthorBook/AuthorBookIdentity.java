package com.example.library.authorbook;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AuthorBookIdentity implements Serializable {

    @Column(name = "author_id")
    @NotNull
    private Long authorID;

    @Column(name = "book_id")
    @NotNull
    private Long bookID;

    AuthorBookIdentity() {

    }

    AuthorBookIdentity(Long authorID, Long bookID) {

        this.authorID = authorID;
        this.bookID = bookID;
    }

    public Long getBookID() {
        return bookID;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public void setBookID(Long bookID) {
        bookID = bookID;
    }

    public void setAuthorID(Long authorID) {
        authorID = authorID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorBookIdentity)) return false;
        AuthorBookIdentity that = (AuthorBookIdentity) o;
        return Objects.equals(getAuthorID(),that.getAuthorID())
                && Objects.equals(getBookID(), that.getBookID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorID(), getBookID());
    }


}

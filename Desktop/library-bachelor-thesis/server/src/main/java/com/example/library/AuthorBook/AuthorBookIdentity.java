package com.example.library.AuthorBook;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class AuthorBookIdentity implements Serializable {

    @Column(name = "author_id")
    @NotNull
    private Long AuthorID;

    @Column(name = "book_id")
    @NotNull
    private Long BookID;


    public Long getBookID() {
        return BookID;
    }

    public Long getAuthorID() {
        return AuthorID;
    }

    public void setBookID(Long bookID) {
        BookID = bookID;
    }

    public void setAuthorID(Long authorID) {
        AuthorID = authorID;
    }

}

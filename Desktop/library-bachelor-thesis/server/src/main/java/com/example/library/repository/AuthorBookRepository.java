package com.example.library.repository;

import com.example.library.model.extensions.AuthorBookIdentity;
import com.example.library.model.AuthorBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorBookRepository extends JpaRepository<AuthorBook, AuthorBookIdentity> {
    List<AuthorBook> findByAuthorBookIdentity_AuthorID(Long authorID);
    List<AuthorBook> findByAuthorBookIdentity_BookID(Long bookID);

}

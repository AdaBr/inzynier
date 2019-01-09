package com.example.library.authorbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AuthorBookRepository extends JpaRepository<AuthorBook, AuthorBookIdentity> {

}

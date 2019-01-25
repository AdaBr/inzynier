package com.example.library.repository;

import com.example.library.model.Author;
import com.example.library.model.extensions.Forename;
import com.example.library.model.extensions.Surname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    /*
    List<Author> findAuthorBySurnameContaining(Surname surname);
    List<Author> findAuthorByForenameContaining(Forename forename);
    */

}

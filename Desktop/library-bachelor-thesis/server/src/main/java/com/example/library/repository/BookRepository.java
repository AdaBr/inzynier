package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    /*TO DO
    List<Book> findByISBNContaining(String ISBN);
    List<Book> findByTitleContaining(String title);
*/

}

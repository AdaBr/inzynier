package com.example.library.repository;

import com.example.library.model.UserBook;
import com.example.library.model.extensions.Status;
import com.example.library.model.extensions.UserBookIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, UserBookIdentity>{
    List<UserBook> findByUserBookIdentity_BookID(Long bookID);
    List<UserBook> findByUserBookIdentity_UserID(Long userID);
    List<UserBook> findByUserBookIdentity_UserIDAndStatus(Long userID, Status status);
}

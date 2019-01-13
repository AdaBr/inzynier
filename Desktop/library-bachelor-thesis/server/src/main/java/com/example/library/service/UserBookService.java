package com.example.library.service;

import com.example.library.model.UserBook;
import com.example.library.model.extensions.Status;
import com.example.library.repository.UserBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookService {
    
    @Autowired
    private UserBookRepository userBookRepository;
    
    
    public List<UserBook> getAllUserBooks(Long userID) {
        return userBookRepository.findByUserBookIdentity_UserID(userID);
    }

    //nie jestem pewna czy to bedzie dzialac testy
    public List<UserBook> getUserBooksWithStatus(Long userID, String chosenStatus) {
        return userBookRepository.findByUserBookIdentity_UserIDAndStatus(userID, Status.valueOf(chosenStatus));
    }
}

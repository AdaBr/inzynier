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
        return userBookRepository.findByUserBookIdentity_UserIDAndStatus(userID, chosenStatus);
    }

    public boolean addBookToUserBooks(UserBook userBook) {

        UserBook alreadyExist = userBookRepository.findByUserBookIdentity(userBook.getUserBookIdentity());
        if (alreadyExist!=null){
            if (!alreadyExist.getStatus().equals(userBook.getStatus()) && !alreadyExist.getStringStatus().equals("DOWNLOADED"))  {
                modifyUserBook(alreadyExist, userBook);
                return true;
            }
        }
        else {
            addUserBook(userBook);
            return true;
        }
        return false;
    }

    private void addUserBook(UserBook userBook) {
        userBookRepository.save(userBook);
    }

    private void modifyUserBook(UserBook alreadyExist, UserBook userBook) {

        if (userBook.getUserBookIdentity().equals(alreadyExist.getUserBookIdentity())) {
            UserBook newUserBook = alreadyExist;
            newUserBook.setUserBookIdentity(alreadyExist.getUserBookIdentity());

            newUserBook.setStatus(userBook.getStatus());
            newUserBook.setDownloadDate(userBook.getDownloadDate());
        }
    }

    public boolean modifyBookFromUserBooks(UserBook userBook) {
        UserBook alreadyExist = userBookRepository.findByUserBookIdentity(userBook.getUserBookIdentity());
        if (alreadyExist!=null){
            if (!alreadyExist.getStatus().equals(userBook.getStatus()) && !alreadyExist.getStringStatus().equals("DOWNLOADED"))  {
                modifyUserBook(alreadyExist, userBook);
                return true;
            }
        }
        return false;
    }
}

package com.example.library.api;

import com.example.library.repository.dto.UserBookDto;
import com.example.library.service.facade.UserBookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userbooks")
public class UserBookEndpoint {

    @Autowired
    private UserBookFacade userBookFacade;


    @RequestMapping(value = "{userID}/status/{chosenStatus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getUserBooksByStatus(@PathVariable Long userID, @PathVariable String chosenStatus) {
        return new ResponseEntity<>(userBookFacade.getUserBooksWithStatus(userID, chosenStatus), HttpStatus.OK);
    }

    @RequestMapping(value = "{userID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllUserBooks(@PathVariable("userID") Long userID) {
        return new ResponseEntity<>(userBookFacade.getAllUserBooks(userID), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> addBookToUserBooks(@RequestBody UserBookDto userBookDto) {
        if (userBookFacade.addBookToUserBooks(userBookDto)) {
            return new ResponseEntity<> (HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> modifyBookFromUserBooks(@RequestBody UserBookDto userBookDto) {
        if (userBookFacade.modifyBookFromUserBooks(userBookDto)) {
            return new ResponseEntity<> (HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}

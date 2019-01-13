package com.example.library.api;

import com.example.library.service.facade.UserBookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}

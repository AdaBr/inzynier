package com.example.library.api;

import com.example.library.service.facade.AuthorBookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authorsbooks")
public class AuthorBookEndpoint {

    @Autowired
    private AuthorBookFacade authorBookFacade;



    @RequestMapping(value = "{authorID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllAuthorsBooks(@PathVariable("authorID") Long authorID) {
        return new ResponseEntity<>(authorBookFacade.getAllAuthorsBookstest(authorID), HttpStatus.OK);
    }


}

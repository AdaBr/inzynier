package com.example.library.authorbook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authorsbooks")
public class AuthorBookEndpoint {

    @Autowired
    AuthorBookFacade authorBookFacade;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(authorBookFacade.getAllAuthorBooks(), HttpStatus.OK);
    }

}

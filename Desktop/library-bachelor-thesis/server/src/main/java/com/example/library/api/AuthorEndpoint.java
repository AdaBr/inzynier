package com.example.library.api;

import com.example.library.service.facade.AuthorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authors")
class AuthorEndpoint {

    @Autowired
    private AuthorFacade authorFacade;


    /*
    @RequestMapping(value = "{authorID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAuthor(@PathVariable("authorID") Long id) {
        return new ResponseEntity<>(authorFacade.getAuthor(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(authorFacade.getAllAuthors(), HttpStatus.OK);
    }

    @RequestMapping(value = "/querys/{bookID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAuthorsForBook(@PathVariable("bookID") Long id) {
        return new ResponseEntity<>(authorFacade.getAuthorsForBook(id), HttpStatus.OK);
    }

/*
    @RequestMapping(value = "/query/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAuthorsByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(authorFacade.getAuthorByName(name), HttpStatus.OK);

    }

    ResponseEntity<?> getPersonById(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorFacade.getAuthor(authorDto), HttpStatus.OK);
    }
    */

}

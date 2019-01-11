package com.example.library.author;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("authors")
//@CrossOrigin
class AuthorEndpoint {

    @Autowired
    private AuthorFacade authorFacade;

    @RequestMapping(value = "{authorID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAuthor(@PathVariable("authorID") Long id) {
        return new ResponseEntity<>(authorFacade.getAuthor(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/querys/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAuthorsByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(authorFacade.getAuthorByName(name), HttpStatus.OK);
        /*
        try {

        }
        catch (AuthorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find author " + "name" , e);

        }
        */
    }

    /*
    ResponseEntity<?> getPersonById(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorFacade.getAuthor(authorDto), HttpStatus.OK);
    }
    */

    //@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(authorFacade.getAllAuthors(), HttpStatus.OK);
    }

    @RequestMapping(value = "/query/{bookID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAuthorsForBook(@PathVariable("bookID") Long id) {
        return new ResponseEntity<>(authorFacade.getAuthorsForBook(id), HttpStatus.OK);
    }


}

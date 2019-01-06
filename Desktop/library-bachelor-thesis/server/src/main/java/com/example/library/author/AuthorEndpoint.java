package com.example.library.author;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author/query")
@CrossOrigin
class AuthorEndpoint {

    @Autowired
    private AuthorFacade authorFacade;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getPerson(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorFacade.getAuthor(authorDto), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllPersons() {
        return new ResponseEntity<>(authorFacade.getAllAuthors(), HttpStatus.OK);
    }

}

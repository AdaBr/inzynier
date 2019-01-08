package com.example.library.book;

import com.example.library.book.BookDto;
import com.example.library.book.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/query")
@CrossOrigin
class BookEndpoint {

    @Autowired
    private BookFacade bookFacade;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookFacade.getBook(bookDto), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookFacade.getAllBooks(), HttpStatus.OK);
    }

}

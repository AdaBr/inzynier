package com.example.library.book;

import com.example.library.book.BookDto;
import com.example.library.book.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
@CrossOrigin
class BookEndpoint {

    @Autowired
    private BookFacade bookFacade;

    @RequestMapping(value = "{bookID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBook(@PathVariable("bookID") Long id) {
        return new ResponseEntity<>(bookFacade.getBook(id), HttpStatus.OK);
    }


    @RequestMapping(value = "query/{title}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBookByTitle(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookFacade.getBookByTitle(title), HttpStatus.OK);
    }

    /*
    @RequestMapping(value = "querys/{author}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBookByAuthorName(@PathVariable("author") String author) {
        return new ResponseEntity<>(bookFacade.getBookByAuthor(author), HttpStatus.OK);
    }
    */


    @RequestMapping(value = "querys/{search}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBookBySearach(@PathVariable("search") String search) {
        return new ResponseEntity<>(bookFacade.getBookBySearch(search), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookFacade.getAllBooks(), HttpStatus.OK);
    }

}

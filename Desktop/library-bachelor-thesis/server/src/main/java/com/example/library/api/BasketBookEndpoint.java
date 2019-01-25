package com.example.library.api;

import com.example.library.model.BasketBook;
import com.example.library.repository.dto.BasketBookDto;
import com.example.library.service.facade.BasketBookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("basketbooks")
public class BasketBookEndpoint {

    @Autowired
    private BasketBookFacade basketBookFacade;


    @RequestMapping(value = "{basketID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBooksFromBasket(@PathVariable("basketID") Long basketID) {
        return new ResponseEntity<>(basketBookFacade.getBooksFromBasketBook(basketID), HttpStatus.OK);
    }

    @RequestMapping(value = "{userID}/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBooksFromUserBasketWithStatus(@PathVariable("userID") Long userID, @PathVariable("status") String status) {
        return new ResponseEntity<>(basketBookFacade.getBooksFromUserBasketWithStatus(userID, status), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> addBookToBasket(@RequestBody BasketBookDto basketBookDto) {
        if (basketBookFacade.addBookToBasketBook(basketBookDto)) {
            return new ResponseEntity<>(basketBookDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(basketBookDto, HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> removeBookFromBasket(@RequestBody BasketBookDto basketBookDto) {
        if (basketBookFacade.removeBookFromBasketBook(basketBookDto)) {
            return new ResponseEntity<>(basketBookDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(basketBookDto, HttpStatus.NOT_FOUND);
        }

    }
}


package com.example.library.api;

import com.example.library.service.facade.BasketFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("baskets")
public class BasketEndpoint {

    @Autowired
    private BasketFacade basketFacade;


    @RequestMapping(value = "{userID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBasketForUser(@PathVariable("userID") Long userID) {
        return new ResponseEntity<>(basketFacade.getAllUserBasket(userID), HttpStatus.OK);
    }

    @RequestMapping(value = "{userID}/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBasketWithStatusForUser(@PathVariable("userID") Long userID, @PathVariable("status") String status) {
        return new ResponseEntity<>(basketFacade.getUserBasketWithStatus(userID, status), HttpStatus.OK);
    }


}

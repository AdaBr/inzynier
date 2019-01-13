package com.example.library.api;

import com.example.library.repository.dto.UserDto;
import com.example.library.service.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserEndpoint {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> registerNewUser(@RequestBody UserDto userDto) {
        if (userFacade.registerNewUser(userDto)) {
            return new ResponseEntity<> (HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //@RequestMapping(value = /reg);

    @RequestMapping(value="/confirm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> confirmNewUserRegistration(@RequestParam("token") String token) {
        if (userFacade.confirmNewUserRegistration(token)) {
            return new ResponseEntity<> (HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> loginUser(@RequestBody String loginPassword) {
        if (userFacade.logInUser(loginPassword)) {
            return new ResponseEntity<> (HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

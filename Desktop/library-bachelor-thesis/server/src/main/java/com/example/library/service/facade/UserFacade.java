package com.example.library.service.facade;

import com.example.library.model.User;
import com.example.library.repository.dto.UserDto;
import com.example.library.repository.mapper.UserMapperImpl;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapperImpl mapper;

    public boolean registerNewUser(UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        return userService.registerNewUser(user);
    }

    public boolean confirmNewUserRegistration(String token) {
        return userService.confirmRegistration(token);
    }

    public boolean logInUser(String loginPassword) {


    }
}

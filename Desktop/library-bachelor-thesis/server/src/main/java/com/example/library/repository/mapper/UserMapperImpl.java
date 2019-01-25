package com.example.library.repository.mapper;

import com.example.library.model.User;
import com.example.library.repository.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    
    @Autowired
    private UserMapper delegate;


    @Override
    public UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto) {

        User user = new User();
        BeanUtils.copyProperties(userDto, user );

        return user;
    }

    public List<UserDto> usersToUserDtos(List<User> userList) {
        List<UserDto> userDtoList = new ArrayList<>();
        userList.stream().forEach(user -> userDtoList.add(userToUserDto(user)));
        return userDtoList;
    }

    List<User> userDtosToUserList(List<UserDto> userDtoList) {
        List<User> userList = new ArrayList<>();
        userDtoList.stream().forEach(userDto -> userList.add(userDtoToUser(userDto)));
        return userList;
    }
}


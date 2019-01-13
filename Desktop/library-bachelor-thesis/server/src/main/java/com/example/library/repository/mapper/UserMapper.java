package com.example.library.repository.mapper;

import com.example.library.model.User;
import com.example.library.repository.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);
}

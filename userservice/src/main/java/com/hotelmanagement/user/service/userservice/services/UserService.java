package com.hotelmanagement.user.service.userservice.services;

import java.util.List;

import com.hotelmanagement.user.service.userservice.payloads.UserDto;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    List<UserDto> getAllUser();
    UserDto getUserById(String userId);
    UserDto updateUser(UserDto userDto, String userId);
    void deleteUser(String userId);
    
}

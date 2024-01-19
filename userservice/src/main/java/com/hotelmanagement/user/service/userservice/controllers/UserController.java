package com.hotelmanagement.user.service.userservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hotelmanagement.user.service.userservice.payloads.UserDto;
import com.hotelmanagement.user.service.userservice.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUser = this.userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> users = this.userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingFallbackMethod" )
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId){
        UserDto user = this.userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
  
    public ResponseEntity<UserDto> ratingFallbackMethod(@PathVariable String userId,Exception ex){
        ex.printStackTrace();
        logger.info("Fallback is executed due to servie down",ex.getMessage());
        UserDto user = UserDto.builder().email("dummyemail@gmail.com")
        .name("Dummy User")
        .id("Dummy__ID")
        .about("Dummy user because service is down")
        .ratings(null).build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    
}

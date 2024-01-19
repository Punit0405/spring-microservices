package com.hotelmanagement.user.service.userservice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelmanagement.user.service.userservice.entities.Hotel;
import com.hotelmanagement.user.service.userservice.entities.Rating;
import com.hotelmanagement.user.service.userservice.entities.User;
import com.hotelmanagement.user.service.userservice.exceptions.ResourceNotFoundException;
import com.hotelmanagement.user.service.userservice.external.services.HotelService;
import com.hotelmanagement.user.service.userservice.payloads.UserDto;
import com.hotelmanagement.user.service.userservice.repositories.UserRepo;
import com.hotelmanagement.user.service.userservice.services.UserService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    private final RestTemplate restTemplate;

    private final HotelService hotelService;

    private  Logger logger = LoggerFactory.getLogger(UserServiceImpl.class); 

    private final ModelMapper modelMapper;
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        user.setId(UUID.randomUUID().toString());
        User savedUser = this.userRepo.save(user);
        return this.modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(user -> this.modelMapper.map(user, UserDto.class)).toList();
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
        //get rating from ratnig service.
        System.out.println("Going to found ratings");
        Rating[] ratingArr = this.restTemplate.getForObject("http://RATING-SERVICE/ratings/user/" + user.getId(), Rating[].class);
        System.out.println("Rating Foundss");

        List<Rating> ratingList = new ArrayList<>(List.of(ratingArr));
        List<Rating> ratingListWithHotel = ratingList.stream().map(rating->{
            Hotel hotel = hotelService.gethHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).toList();
        this.logger.info("" + ratingList);
        user.setRatings(ratingListWithHotel);
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
    
}

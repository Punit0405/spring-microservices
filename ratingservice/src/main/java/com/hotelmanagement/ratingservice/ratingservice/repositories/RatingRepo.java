package com.hotelmanagement.ratingservice.ratingservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotelmanagement.ratingservice.ratingservice.entities.Rating;

public interface RatingRepo extends MongoRepository<Rating,String> {

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}

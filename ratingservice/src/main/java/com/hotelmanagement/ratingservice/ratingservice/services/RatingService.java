package com.hotelmanagement.ratingservice.ratingservice.services;

import java.util.List;

import com.hotelmanagement.ratingservice.ratingservice.payloads.RatingDto;

public interface RatingService {
    RatingDto createRating(RatingDto ratingDto);

    RatingDto updateRating(RatingDto ratingDto);
    
    RatingDto getRatingById(String id);

    void deleteRating(String id);

    List<RatingDto> getAllRatings();
    List<RatingDto> getAllByUser(String userId);
    List<RatingDto> getAllByHotel(String hotelId);

}

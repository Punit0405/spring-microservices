package com.hotelmanagement.ratingservice.ratingservice.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.ratingservice.ratingservice.payloads.RatingDto;
import com.hotelmanagement.ratingservice.ratingservice.services.RatingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("/")
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto) {
        RatingDto createdRating = this.ratingService.createRating(ratingDto);
        return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(createdRating);
    }

    @GetMapping("/")
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        List<RatingDto> ratings = this.ratingService.getAllRatings();
        return ResponseEntity.status(org.springframework.http.HttpStatus.OK).body(ratings);
    }

    @GetMapping("/rating/{ratingId}")
    public ResponseEntity<RatingDto> getRatingById(@PathVariable String ratingId) {
        RatingDto rating = this.ratingService.getRatingById(ratingId);
        return ResponseEntity.status(org.springframework.http.HttpStatus.OK).body(rating);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingDto>> getAllRatingsByUser(@PathVariable String userId) {
        List<RatingDto> ratings = this.ratingService.getAllByUser(userId);
        return ResponseEntity.status(org.springframework.http.HttpStatus.OK).body(ratings);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RatingDto>> getAllRatingsByHotel(@PathVariable String hotelId) {
        List<RatingDto> ratings = this.ratingService.getAllByHotel(hotelId);
        return ResponseEntity.status(org.springframework.http.HttpStatus.OK).body(ratings);
    }
}

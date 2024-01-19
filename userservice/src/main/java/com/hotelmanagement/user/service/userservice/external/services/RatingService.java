package com.hotelmanagement.user.service.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotelmanagement.user.service.userservice.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @PostMapping("/ratings/")
    Rating createRatnig(Rating rating);
}

package com.hotelmanagement.ratingservice.ratingservice.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.hotelmanagement.ratingservice.ratingservice.entities.Rating;
import com.hotelmanagement.ratingservice.ratingservice.payloads.RatingDto;
import com.hotelmanagement.ratingservice.ratingservice.repositories.RatingRepo;
import com.hotelmanagement.ratingservice.ratingservice.services.RatingService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepo ratingRepo;
    private final ModelMapper modelMapper;
    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        Rating rating = this.ratingRepo.save(this.modelMapper.map(ratingDto, Rating.class));
        return this.modelMapper.map(rating, RatingDto.class);
    }

    @Override
    public RatingDto updateRating(RatingDto ratingDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRating'");
    }

    @Override
    public RatingDto getRatingById(String id) {
        return this.modelMapper.map(this.ratingRepo.findById(id).get(), RatingDto.class);
    }

    @Override
    public void deleteRating(String id) {
        this.ratingRepo.deleteById(id);
    }

    @Override
    public List<RatingDto> getAllRatings() {
        List<Rating> ratings = this.ratingRepo.findAll();
        List<RatingDto> ratingDtos = ratings.stream().map(rating -> this.modelMapper.map(rating, RatingDto.class)).toList();
        return ratingDtos;
    }

    @Override
    public List<RatingDto> getAllByUser(String userId) {
        return this.ratingRepo.findByUserId(userId).stream().map(rating -> this.modelMapper.map(rating, RatingDto.class)).toList();
    }

    @Override
    public List<RatingDto> getAllByHotel(String hotelId) {
        return this.ratingRepo.findByHotelId(hotelId).stream().map(rating -> this.modelMapper.map(rating, RatingDto.class)).toList();
    }
    
}

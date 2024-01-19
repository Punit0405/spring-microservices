package com.hotelmanagement.hotelservice.hotelservice.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.hotelmanagement.hotelservice.hotelservice.entities.Hotel;
import com.hotelmanagement.hotelservice.hotelservice.payloads.HotelDto;
import com.hotelmanagement.hotelservice.hotelservice.repositories.HotelRepo;
import com.hotelmanagement.hotelservice.hotelservice.services.HotelService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final ModelMapper modelMapper;

    private final HotelRepo hotelRepo;
    @Override
    public HotelDto saveHotel(HotelDto hotelDto) {
        Hotel hotel = this.modelMapper.map(hotelDto, Hotel.class);
        hotel.setId(UUID.randomUUID().toString());
        Hotel savedHotel = this.hotelRepo.save(hotel);
        return this.modelMapper.map(savedHotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(String hotelId) {
        Optional<Hotel> optionalHotel = this.hotelRepo.findById(hotelId);
         Hotel hotel  = optionalHotel.get();
         return this.modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public void deleteHotel(String hotelId) {
        Optional<Hotel> optionalHotel = this.hotelRepo.findById(hotelId);
         Hotel hotel  = optionalHotel.get();
        this.hotelRepo.delete(hotel);
    }

    @Override
    public HotelDto updateHotel(String hotelId, HotelDto hotelDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateHotel'");
    }

    @Override
    public List<HotelDto> getAllHotels() {
        List<Hotel> hotels = this.hotelRepo.findAll();
        List<HotelDto> hotelDtos = hotels.stream().map(ho->this.modelMapper.map(ho, HotelDto.class)).toList();
        return hotelDtos;
        
    }
    
}

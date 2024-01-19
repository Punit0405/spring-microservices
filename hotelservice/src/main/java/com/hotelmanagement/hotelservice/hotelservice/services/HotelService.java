package com.hotelmanagement.hotelservice.hotelservice.services;

import com.hotelmanagement.hotelservice.hotelservice.payloads.HotelDto;
import java.util.List;

public interface HotelService {

    public HotelDto saveHotel(HotelDto hotelDto);

    public HotelDto getHotelById(String hotelId);

    public void deleteHotel(String hotelId);

    public HotelDto updateHotel(String hotelId, HotelDto hotelDto);

    public List<HotelDto> getAllHotels();


}

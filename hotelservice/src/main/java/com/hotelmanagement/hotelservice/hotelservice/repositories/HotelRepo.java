package com.hotelmanagement.hotelservice.hotelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.hotelservice.hotelservice.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel,String> {

    
}

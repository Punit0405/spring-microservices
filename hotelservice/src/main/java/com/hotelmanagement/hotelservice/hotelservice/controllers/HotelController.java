package com.hotelmanagement.hotelservice.hotelservice.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.hotelservice.hotelservice.payloads.HotelDto;
import com.hotelmanagement.hotelservice.hotelservice.services.HotelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    @PostMapping("/")
    public ResponseEntity<HotelDto> saveHotel(@Valid @RequestBody HotelDto hotel){
        System.out.println("Hey");
        HotelDto savedHotel = this.hotelService.saveHotel(hotel);
        System.out.println("Saved Hotel --->" + savedHotel );
        return   ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    @GetMapping("/")
    public ResponseEntity<List<HotelDto>> getAllHotels(){
        List<HotelDto> hotels = this.hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable String hotelId){
        System.out.println("Fetching Hotel ");
        HotelDto hotel = this.hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable String hotelId){
        this.hotelService.deleteHotel(hotelId);
        return ResponseEntity.ok("Hotel Deleted Successfully");
    }
}

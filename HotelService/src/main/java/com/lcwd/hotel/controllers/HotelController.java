package com.lcwd.hotel.controllers;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel>getSingleHotel(@PathVariable String id){
        Hotel hotel = hotelService.getById(id);
        return ResponseEntity.ok(hotel);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>>getAll(){
        List<Hotel> allHotels = hotelService.getAll();
        return ResponseEntity.ok(allHotels);
    }
}

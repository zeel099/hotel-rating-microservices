package com.lcwd.rating.controllers;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable String id){
        Rating rating = ratingService.getRating(id);
        return ResponseEntity.ok(rating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> ratingList = ratingService.getAllRating();
        return ResponseEntity.ok(ratingList);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        List<Rating> userRatingList = ratingService.getRatingsByUserId(userId);
        return ResponseEntity.ok(userRatingList);
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        List<Rating> hotelRatingList = ratingService.getRatingsByHotelId(hotelId);
        return ResponseEntity.ok(hotelRatingList);
    }
}

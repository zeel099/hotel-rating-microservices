package com.lcwd.rating.services.impl;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.exceptions.ResourceNotFoundException;
import com.lcwd.rating.repositories.RatingRepository;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        String randomUUID = UUID.randomUUID().toString();
        rating.setRatingId(randomUUID);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRating(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating with given id is not found on server"+ratingId));
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}

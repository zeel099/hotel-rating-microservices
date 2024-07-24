package com.lcwd.rating.services;

import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);

    List<Rating> getAllRating();

    Rating getRating(String ratingId);

    List<Rating> getRatingsByUserId(String userId);

    List<Rating> getRatingsByHotelId(String hotelId);
}

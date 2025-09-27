package com.hotelratingservice.service;

import com.hotelratingservice.dto.HotelRatingServiceDTO;

import java.util.List;

public interface HotelRatingService {

     HotelRatingServiceDTO insertRating(HotelRatingServiceDTO details);

     List<HotelRatingServiceDTO> getDetailsByUserId(String id);
}

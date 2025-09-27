package com.hotelservice.services;

import com.hotelservice.dto.HotelDetailsDTO;

import java.util.List;

public interface HotelDetailsService {

    HotelDetailsDTO create(HotelDetailsDTO detailsDTO);


    HotelDetailsDTO updateDetails(HotelDetailsDTO detailsDTO);


    List<HotelDetailsDTO> getHotelList();

    HotelDetailsDTO getHotel(String id);

    String deleteHotel(String id);


}

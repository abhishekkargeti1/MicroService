package com.hotelservice.services;

import com.hotelservice.dto.HotelDetailsDTO;

import java.util.List;

public interface HotelDetailsService {

     HotelDetailsDTO create(HotelDetailsDTO detailsDTO);


     HotelDetailsDTO updateDetails(HotelDetailsDTO detailsDTO);


     List<HotelDetailsDTO> getHotelList();

    public HotelDetailsDTO getHotel(String id);

    public String deleteHotel(String id);
}

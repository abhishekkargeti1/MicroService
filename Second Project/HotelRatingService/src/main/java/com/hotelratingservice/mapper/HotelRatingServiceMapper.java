package com.hotelratingservice.mapper;

import com.hotelratingservice.dto.HotelRatingServiceDTO;
import com.hotelratingservice.entities.HotelRatingServiceEntity;

public class HotelRatingServiceMapper {

    HotelRatingServiceEntity getEntity(HotelRatingServiceDTO dtoDetails){
        HotelRatingServiceEntity entityDetails = new HotelRatingServiceEntity();


        return entityDetails;
    }

    HotelRatingServiceDTO getDTO(HotelRatingServiceEntity entityDetails){
        HotelRatingServiceDTO dtoDetails = new HotelRatingServiceDTO();

        return dtoDetails;
    }

}

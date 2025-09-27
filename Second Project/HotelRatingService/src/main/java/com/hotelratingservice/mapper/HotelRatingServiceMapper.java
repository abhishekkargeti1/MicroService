package com.hotelratingservice.mapper;

import com.hotelratingservice.dto.HotelRatingServiceDTO;
import com.hotelratingservice.entities.HotelRatingServiceEntity;

import java.util.ArrayList;
import java.util.List;

public class HotelRatingServiceMapper {

    public static HotelRatingServiceEntity getEntity(HotelRatingServiceDTO dtoDetails) {
        HotelRatingServiceEntity entityDetails = new HotelRatingServiceEntity();

        if (dtoDetails.getRatingId() != null && !dtoDetails.getRatingId().isBlank()) {
            entityDetails.setRatingId(dtoDetails.getRatingId());
        }

        entityDetails.setHotelId(dtoDetails.getHotelId());
        entityDetails.setUserId(dtoDetails.getUserId());
        entityDetails.setRating(dtoDetails.getRating());
        entityDetails.setFeedback(dtoDetails.getFeedback());

        return entityDetails;
    }

    public static HotelRatingServiceDTO getDTO(HotelRatingServiceEntity entityDetails) {
        HotelRatingServiceDTO dtoDetails = new HotelRatingServiceDTO();
        dtoDetails.setRatingId(entityDetails.getRatingId());
        dtoDetails.setHotelId(entityDetails.getHotelId());
        dtoDetails.setRating(entityDetails.getRating());
        dtoDetails.setUserId(entityDetails.getUserId());
        dtoDetails.setFeedback(entityDetails.getFeedback());
        return dtoDetails;
    }

    public static List<HotelRatingServiceDTO> getDTOList(List<HotelRatingServiceEntity> enityList) {
        HotelRatingServiceDTO dtoDetails = null;
        List<HotelRatingServiceDTO> dtoList = new ArrayList<>();
        for (HotelRatingServiceEntity e : enityList) {
            dtoDetails = new HotelRatingServiceDTO();
            dtoDetails.setRatingId(e.getRatingId());
            dtoDetails.setHotelId(e.getHotelId());
            dtoDetails.setRating(e.getRating());
            dtoDetails.setUserId(e.getUserId());
            dtoDetails.setFeedback(e.getFeedback());
            dtoList.add(dtoDetails);
        }
        return dtoList;

    }

}

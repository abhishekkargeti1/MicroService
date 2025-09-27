package com.hotelratingservice.service;

import com.hotelratingservice.dto.HotelRatingServiceDTO;
import com.hotelratingservice.entities.HotelRatingServiceEntity;
import com.hotelratingservice.mapper.HotelRatingServiceMapper;
import com.hotelratingservice.respository.HotelRatingServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelRatingServiceImpl implements HotelRatingService {

    @Autowired
    HotelRatingServiceRepository repository;

    @Override
    public HotelRatingServiceDTO insertRating(HotelRatingServiceDTO details) {

        HotelRatingServiceEntity entity = HotelRatingServiceMapper.getEntity(details);
        try {
            entity.setRatingId(UUID.randomUUID().toString());
            HotelRatingServiceEntity savedDetails = repository.save(entity);
            HotelRatingServiceDTO dto = HotelRatingServiceMapper.getDTO(savedDetails);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Something Went Wrong !!!");
        }
    }

    @Override
    public List<HotelRatingServiceDTO> getDetailsByUserId(String id) {
      List<HotelRatingServiceEntity> entity =  repository.findByUserId(id);
         List<HotelRatingServiceDTO> dtoDetails =  HotelRatingServiceMapper.getDTOList(entity);
         return dtoDetails;


    }
}

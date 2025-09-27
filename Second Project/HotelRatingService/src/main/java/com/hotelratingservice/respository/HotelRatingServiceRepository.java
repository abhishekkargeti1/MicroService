package com.hotelratingservice.respository;

import com.hotelratingservice.entities.HotelRatingServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRatingServiceRepository extends JpaRepository<HotelRatingServiceEntity,String> {


    public List<HotelRatingServiceEntity> findByUserId(String id);
}

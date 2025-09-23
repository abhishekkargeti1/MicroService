package com.hotelratingservice.respository;

import com.hotelratingservice.entities.HotelRatingServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRatingServiceRepository extends JpaRepository<HotelRatingServiceEntity,String> {
}

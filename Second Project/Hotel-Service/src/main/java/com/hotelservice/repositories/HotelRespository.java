package com.hotelservice.repositories;

import com.hotelservice.entities.HotelDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRespository extends JpaRepository<HotelDetailsEntity ,String> {
}

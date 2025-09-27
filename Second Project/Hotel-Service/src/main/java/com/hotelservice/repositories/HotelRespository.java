package com.hotelservice.repositories;

import com.hotelservice.entities.HotelDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRespository extends JpaRepository<HotelDetailsEntity ,String> {


}

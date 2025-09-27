package com.org.user.service.UserService.servicesImpl;

import com.org.user.service.UserService.entities.HotelDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="HotelService" , url="http://localhost:8081")
public interface HotelDetailService {


    @GetMapping("/hotel/hotelDetails/{id}")
    public HotelDetails getHotelDetails(@PathVariable String id);

}

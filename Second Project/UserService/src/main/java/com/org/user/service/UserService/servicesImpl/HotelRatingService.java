package com.org.user.service.UserService.servicesImpl;

import com.org.user.service.UserService.entities.HotelRating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "HotelRatingService", url = "http://localhost:8002")
public interface HotelRatingService {

    @GetMapping("/ratingservice/{id}")
    public List<HotelRating> getDetailsByUserId(@PathVariable String id);

}

package com.hotelratingservice.controller;


import com.hotelratingservice.dto.HotelRatingServiceDTO;
import com.hotelratingservice.service.HotelRatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratingservice")
public class HotelRatingServiceController {

    @Autowired
    private HotelRatingServiceImpl service;

    @PostMapping("/rate")
    public ResponseEntity<?> giveFeedBack(@RequestBody HotelRatingServiceDTO dtoDetails) {
        HotelRatingServiceDTO finalDetails = service.insertRating(dtoDetails);
        return ResponseEntity.status(HttpStatus.OK).body(finalDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRatingByUserId(@PathVariable String id){
       List<HotelRatingServiceDTO> dtoDetailList =service.getDetailsByUserId(id);
       if (!dtoDetailList.isEmpty()){
           return ResponseEntity.status(HttpStatus.OK).body(dtoDetailList);
       }else{
           throw new RuntimeException("No Data Found");
       }
    }
}

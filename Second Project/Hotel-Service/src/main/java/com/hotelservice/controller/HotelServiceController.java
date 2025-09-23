package com.hotelservice.controller;

import com.hotelservice.dto.HotelDetailsDTO;
import com.hotelservice.serviceimpl.HotelDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hotel")
public class HotelServiceController {

    @Autowired
    private HotelDetailsServiceImpl service;

    @PostMapping("/createHotel")
    public ResponseEntity<?> createHotelDetails(@Valid @RequestBody HotelDetailsDTO dto) {

        HotelDetailsDTO finalDetails = service.create(dto);
        if (finalDetails != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(finalDetails);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
    }

    @PatchMapping("/updateHotel")
    public ResponseEntity<?> updateHotelDetails(@Valid @RequestBody HotelDetailsDTO dto) {

        if(dto.getId() == null){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Provide Id ");
        }
        //System.out.println("DTO in Controller "+dto);
        HotelDetailsDTO updatedDetails = service.updateDetails(dto);
        if (updatedDetails != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedDetails);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
        }
    }


    @GetMapping("/hotelList")
    public ResponseEntity<?> getHotelDetails() {
        List<HotelDetailsDTO> finalDetails = service.getHotelList();

        if (!finalDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(finalDetails);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found");
    }

    @GetMapping("/hotelDetails/{id}")
    public ResponseEntity<?> getHotel(@PathVariable String id) {
        HotelDetailsDTO finalDetails = service.getHotel(id);
        return ResponseEntity.status(HttpStatus.OK).body(finalDetails);
    }

    @DeleteMapping("/deleteHotel/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable String id) {
        String status = service.deleteHotel(id);

        if ("true".equals(status)) {
            return ResponseEntity.status(HttpStatus.OK).body("Details Successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went Wrong");
    }


}

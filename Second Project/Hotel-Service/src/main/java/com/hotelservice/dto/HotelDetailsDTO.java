package com.hotelservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HotelDetailsDTO {

    private String id;

    @NotBlank(message="Please Enter Hotel Name")
    private String hotelName;

    @NotBlank(message="Please Enter Hotel Type")
    private String hotelType;

    @NotBlank(message="Please Enter Hotel Address")
    private String hotelAddress;

    @NotBlank(message="Please Enter Contract Number")
    private String hotelContact;





}

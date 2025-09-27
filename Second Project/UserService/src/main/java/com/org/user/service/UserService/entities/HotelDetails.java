package com.org.user.service.UserService.entities;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelDetails {
    private String id;

    private String hotelName;


    private String hotelType;

    private String hotelAddress;


    private String hotelContact;
}

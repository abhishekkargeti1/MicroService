package com.org.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelRating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;



}

package com.org.user.service.UserService.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelRating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String feedback;



}

package com.hotelratingservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HotelRatingServiceDTO {

    private  String ratingId;
    @NotNull(message = "Please Enter user id")
    private String userId;
    @NotNull(message = "Please Enter Hotel id")
    private String hotelId;
    @NotNull(message = "Please Enter rating")
    private String rating;
    @NotNull(message = "Please Enter Feedback")
    private String feedback;
}

package com.hotelratingservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Hotel_Rating_Details")
public class HotelRatingServiceEntity {

    @Id
    private String ratingId;
    @Column(name="UserId")
    private String userId;
    @Column(name="HotelId")
    private String hotelId;
    @Column(name="Rating")
    private String rating;
    @Column(name="Feedback")
    private String feedback;

}

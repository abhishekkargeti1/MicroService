package com.hotelservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="HotelDetails")
public class HotelDetailsEntity {
    @Id
    private String id;

    @Column(name = "Hotel_Name")
    private String hotelName;

    @Column(name = "Hotel_Type")
    private String hotelType;

    @Column(name = "Hotel_Address")
    private String hotelAddress;

    @Column(name = "Hotel_Contract")
    private String hotelContact;




}

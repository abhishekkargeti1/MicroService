package com.org.user.service.UserService.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.org.user.service.UserService.entities.HotelRating;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDTO {


    private String id;

    @NotBlank(message = "Name should not be null")
    @Size(message = "Name should be atleast of 3 words",min = 3)
    private String name;
    @Email(message = "Not Valid Email")
    @NotBlank(message = "Email should not be null")
    private String email;
    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password should not be null")
    private String password;

    private String about;

    private List<HotelRating> ratingList;


}

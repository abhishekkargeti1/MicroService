package com.org.user.service.UserService.controllers;

import com.org.user.service.UserService.dto.UserDTO;
import com.org.user.service.UserService.servicesImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl service;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO details, BindingResult result) {
        //System.out.println("Details is Controller "+details);
        if (result.hasErrors()) {
            List<String> errorMessage = new ArrayList<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMessage.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        UserDTO saveddetails = service.createUser(details);
        if (saveddetails != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(saveddetails);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Adding New User");
    }

    @GetMapping("/allDetails")
    public ResponseEntity<?> getAllUserDetails() {
        List<UserDTO> details = service.getAllUserDetails();

        if (details != null) {
            return ResponseEntity.status(HttpStatus.OK).body(details);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found");
    }

    @GetMapping("/byUserId/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id) {
        UserDTO details = service.getUserDetailsById(id);
        try {
            if (details != null) {
                return ResponseEntity.status(HttpStatus.OK).body(details);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User By This Id " + id);
        }
    }

    @PutMapping("/updateDetails")
    public ResponseEntity<?> updateUserDetailsById(@Valid @RequestBody UserDTO updatedDetails, BindingResult result) {

            if (result.hasErrors()) {
                List<String> errorMessage = new ArrayList<>();
                for (FieldError errors : result.getFieldErrors()) {
                    errorMessage.add(errors.getDefaultMessage());
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
            }

            if (updatedDetails.getId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User ID must be provided.");
            }
            UserDTO finalDetails = service.updateUserDetails(updatedDetails);
            if (finalDetails != null) {
                return ResponseEntity.status(HttpStatus.OK).body(finalDetails);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");

            }

    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUserDetails(@PathVariable UUID id) {

        String result = service.deteleUserDetails(id);
        if (result.equals("true")) {
            return ResponseEntity.status(HttpStatus.OK).body("User Details Successfully Deleted");
        } else if (result.equals("No Data Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Details Not Found");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
        }
    }
}

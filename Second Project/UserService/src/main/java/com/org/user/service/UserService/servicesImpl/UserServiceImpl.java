package com.org.user.service.UserService.servicesImpl;

import com.org.user.service.UserService.dto.UserDTO;
import com.org.user.service.UserService.entities.HotelDetails;
import com.org.user.service.UserService.entities.HotelRating;
import com.org.user.service.UserService.entities.UserEntity;
import com.org.user.service.UserService.mapper.UserMapper;
import com.org.user.service.UserService.repositories.UserRepository;
import com.org.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private HotelRatingService hotelRatingService;

    @Autowired
    private HotelDetailService hotelDetailService;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO details) {

        UserEntity entity = UserMapper.getEntity(details);
        try {
            entity.setId(UUID.randomUUID().toString());
            UserEntity detailsReceived = repository.save(entity);
            //System.out.println("Details in service "+ detailsReceived);
            UserDTO finalDetails = UserMapper.getDTO(detailsReceived);
            return finalDetails;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while creating user");
        }


    }

    @Override
    public List<UserDTO> getAllUserDetails() {
        List<HotelRating> hotelRatings = new ArrayList<>();
        List<UserEntity> userList = repository.findAll();
        List<UserDTO> finalList = UserMapper.getDTOList(userList);
        for (UserDTO dto : finalList) {
            hotelRatings = hotelRatingService.getDetailsByUserId(dto.getId());
            dto.setRatingList(hotelRatings);
            List<HotelDetails> hotelDetails = new ArrayList<>();
            for (HotelRating rating : hotelRatings) {
                HotelDetails details = hotelDetailService.getHotelDetails(rating.getHotelId());
                hotelDetails.add(details);
            }
            dto.setHotelDetails(hotelDetails);
        }


        System.out.println("User List " + finalList);
        return finalList;
    }

    @Override
    public UserDTO getUserDetailsById(String id) {
        Optional<UserEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            UserDTO details = UserMapper.getDTO(entity.get());

           List<HotelRating> ratings = hotelRatingService.getDetailsByUserId(details.getId());
            details.setRatingList(ratings);
            List<HotelDetails> hotelDetailsList = new ArrayList<>();
            for(HotelRating r : ratings){
               HotelDetails hotelDetails = hotelDetailService.getHotelDetails(r.getHotelId());
               hotelDetailsList.add(hotelDetails);
               details.setHotelDetails(hotelDetailsList);
            }


            return details;
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }

    }

    @Override
    public UserDTO updateUserDetails(UserDTO userDTO) {

        Optional<UserEntity> details = repository.findById(userDTO.getId());

        if (details.isPresent()) {
            UserEntity entity = details.get();
            entity.setAbout(userDTO.getAbout());
            entity.setEmail(userDTO.getEmail());
            entity.setPassword(userDTO.getPassword());
            entity.setEmail(userDTO.getEmail());

            UserEntity updatedDetails = repository.save(entity);


            UserDTO finalDTO = UserMapper.getDTO(updatedDetails);

            return finalDTO;
        } else {
            throw new RuntimeException("No Data Found on This Id");
        }
    }

    @Override
    public String deteleUserDetails(String id) {
        Optional<UserEntity> details = repository.findById(id);
        if (details.isPresent()) {
            UserEntity entity = details.get();
            repository.delete(entity);
            return "true";
        } else {
            return "No Data Found";
        }

    }
}

package com.hotelservice.mapper;

import com.hotelservice.dto.HotelDetailsDTO;
import com.hotelservice.entities.HotelDetailsEntity;

import java.util.ArrayList;
import java.util.List;

public class HotelMapper {


    public static HotelDetailsEntity getEntity(HotelDetailsDTO detailsDTO){
        HotelDetailsEntity entity = new HotelDetailsEntity();
            if(detailsDTO.getId() != null && !detailsDTO.getId().isBlank()){
                entity.setId(detailsDTO.getId());
            }
        entity.setHotelName(detailsDTO.getHotelName());
        entity.setHotelType(detailsDTO.getHotelType());
        entity.setHotelContact(detailsDTO.getHotelContact());
        entity.setHotelAddress(detailsDTO.getHotelAddress());
        return entity;

    }

    public static HotelDetailsDTO getDTO(HotelDetailsEntity detailsEntity){
        HotelDetailsDTO dto = new HotelDetailsDTO();
        dto.setId(detailsEntity.getId());
        dto.setHotelName(detailsEntity.getHotelName());
        dto.setHotelType(detailsEntity.getHotelType());
        dto.setHotelContact(detailsEntity.getHotelContact());
        dto.setHotelAddress(detailsEntity.getHotelAddress());
        return dto;
    }


    public static List<HotelDetailsDTO> getDTOList(List<HotelDetailsEntity> hotleList){
        HotelDetailsDTO dto = null;
        List<HotelDetailsDTO> dtoList = new ArrayList<>();
        for(HotelDetailsEntity entity : hotleList){
            dto =new HotelDetailsDTO();
            dto.setId(entity.getId());
            dto.setHotelName(entity.getHotelName());
            dto.setHotelType(entity.getHotelType());
            dto.setHotelAddress(entity.getHotelAddress());
            dto.setHotelContact(entity.getHotelContact());
            dtoList.add(dto);
        }
        return dtoList;


    }

}

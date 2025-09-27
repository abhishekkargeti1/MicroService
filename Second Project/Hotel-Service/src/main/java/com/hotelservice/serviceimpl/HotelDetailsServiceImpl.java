package com.hotelservice.serviceimpl;

import com.hotelservice.dto.HotelDetailsDTO;
import com.hotelservice.entities.HotelDetailsEntity;
import com.hotelservice.mapper.HotelMapper;
import com.hotelservice.repositories.HotelRespository;
import com.hotelservice.services.HotelDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class HotelDetailsServiceImpl implements HotelDetailsService {

    @Autowired
    private HotelRespository respository;

    @Transactional
    @Override
    public HotelDetailsDTO create(HotelDetailsDTO detailsDTO) {
        HotelDetailsEntity entity = HotelMapper.getEntity(detailsDTO);
        try {
            entity.setId(UUID.randomUUID().toString());
            HotelDetailsEntity savedDetails = respository.save(entity);
            HotelDetailsDTO dto = HotelMapper.getDTO(savedDetails);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Something Went Wrong");
        }
    }

    @Transactional
    @Override
    public HotelDetailsDTO updateDetails(HotelDetailsDTO detailsDTO) {

        HotelDetailsEntity newDetails = HotelMapper.getEntity(detailsDTO);
        Optional<HotelDetailsEntity> details = respository.findById(newDetails.getId());

        if (details.isPresent()) {
            HotelDetailsEntity entity = details.get();
            entity.setHotelName(detailsDTO.getHotelName());
            entity.setHotelType(detailsDTO.getHotelType());
            entity.setHotelContact(detailsDTO.getHotelContact());
            entity.setHotelAddress(detailsDTO.getHotelAddress());
            HotelDetailsEntity savedDetails = respository.save(entity);
            HotelDetailsDTO finalDetails = HotelMapper.getDTO(savedDetails);
            return finalDetails;
        } else {
            throw new RuntimeException("No Details Found");
        }
    }

    @Override
    public List<HotelDetailsDTO> getHotelList() {

        List<HotelDetailsEntity> hotelList = respository.findAll();
        List<HotelDetailsDTO> finalDetails = HotelMapper.getDTOList(hotelList);
        return finalDetails;
    }
    @Override
    public HotelDetailsDTO getHotel(String id) {
        Optional<HotelDetailsEntity> details = respository.findById(id);
        if (details.isPresent()) {
            HotelDetailsEntity entity = details.get();
            HotelDetailsDTO detailsDTO = HotelMapper.getDTO(entity);
            return detailsDTO;
        } else {
            throw new RuntimeException("No Details Found");
        }
    }

    @Override
    public String deleteHotel(String id) {
       Optional<HotelDetailsEntity> details= respository.findById(id);
       if(details.isPresent()){
          HotelDetailsEntity entity = details.get();
          respository.delete(entity);
          return "true";
       }
       throw new RuntimeException("No Details Found");
    }


}

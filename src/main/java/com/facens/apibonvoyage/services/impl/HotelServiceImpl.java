package com.facens.apibonvoyage.services.impl;

import com.facens.apibonvoyage.dtos.hotel.HotelDTO;
import com.facens.apibonvoyage.dtos.hotel.HotelInsertDTO;
import com.facens.apibonvoyage.dtos.hotel.HotelUpdateDTO;
import com.facens.apibonvoyage.entities.Hotel;
import com.facens.apibonvoyage.exceptions.BadRequestException;
import com.facens.apibonvoyage.factories.HotelFatory;
import com.facens.apibonvoyage.repositories.HotelRepository;
import com.facens.apibonvoyage.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    private final String MESSAGE_HOTEL_NOT_FOUND = "Hotel não encontrado";

    @Override
    public List<HotelDTO> getAllHotels() {
        List<Hotel> list = hotelRepository.findAll();
        return list.stream().map(HotelFatory::createFromEntity).collect(Collectors.toList());
    }

    @Override
    public HotelDTO getHotelById(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if(hotel.isPresent()){
            return HotelFatory.createFromEntity(hotel.get());
        } else {
            throw new BadRequestException(MESSAGE_HOTEL_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public HotelDTO insertHotel(HotelInsertDTO dto) {
        Hotel hotel = HotelFatory.createFromInsert(dto);
        hotel = hotelRepository.save(hotel);
        return HotelFatory.createFromEntity(hotel);
    }

    @Override
    public HotelDTO updateHotel(Long id, HotelUpdateDTO dto) {
        HotelDTO hotel = getHotelById(id);
        Hotel hotelSaved = HotelFatory.createFromUpdate(dto, hotel);
        hotelSaved = hotelRepository.save(hotelSaved);
        return HotelFatory.createFromEntity(hotelSaved);
    }

    @Override
    public void deleteHotel(Long id) {
        HotelDTO hotel = getHotelById(id);
        hotelRepository.deleteById(hotel.getId());
    }
}

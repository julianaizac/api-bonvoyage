package com.facens.apibonvoyage.services;

import com.facens.apibonvoyage.dtos.hotel.HotelDTO;
import com.facens.apibonvoyage.dtos.hotel.HotelInsertDTO;
import com.facens.apibonvoyage.dtos.hotel.HotelUpdateDTO;

import java.util.List;

public interface HotelService {
    List<HotelDTO> getAllHotels();

    HotelDTO getHotelById(Long id);

    HotelDTO insertHotel(HotelInsertDTO dto);

    HotelDTO updateHotel(Long id, HotelUpdateDTO dto);

    void deleteHotel(Long id);
}

package com.facens.apibonvoyage.domain.services;

import com.facens.apibonvoyage.application.dtos.hotel.HotelDTO;
import com.facens.apibonvoyage.application.dtos.hotel.HotelInsertDTO;
import com.facens.apibonvoyage.application.dtos.hotel.HotelUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface HotelService {
    List<HotelDTO> getAllHotels();

    HotelDTO getHotelById(UUID id);

    HotelDTO insertHotel(HotelInsertDTO dto);

    HotelDTO updateHotel(UUID id, HotelUpdateDTO dto);

    void deleteHotel(UUID id);
}

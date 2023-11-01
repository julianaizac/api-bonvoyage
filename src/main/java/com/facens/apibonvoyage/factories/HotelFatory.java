package com.facens.apibonvoyage.factories;

import com.facens.apibonvoyage.dtos.hotel.HotelDTO;
import com.facens.apibonvoyage.dtos.hotel.HotelInsertDTO;
import com.facens.apibonvoyage.dtos.hotel.HotelUpdateDTO;
import com.facens.apibonvoyage.entities.Hotel;

import java.util.Objects;

public class HotelFatory {


    public static HotelDTO createFromEntity(Hotel hotel){
        return HotelDTO.builder()
                .id(hotel.getId())
                .nome(hotel.getNome())
                .endereco(hotel.getEndereco())
                .quartos(null)
                .build();
    }

    public static Hotel createFromInsert(HotelInsertDTO dto){
        return Hotel.builder()
                .nome(dto.getNome())
                .endereco(dto.getEndereco())
                .build();
    }

    public static Hotel createFromUpdate(HotelUpdateDTO dto, HotelDTO hotel){
        return Hotel.builder()
                .id(hotel.getId())
                .nome(Objects.nonNull(dto.getNome()) ? dto.getNome() : hotel.getNome())
                .endereco(Objects.nonNull(dto.getEndereco()) ? dto.getEndereco() : hotel.getNome())
                .build();
    }
}

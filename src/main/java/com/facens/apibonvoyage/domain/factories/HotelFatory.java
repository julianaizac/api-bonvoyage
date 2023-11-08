package com.facens.apibonvoyage.domain.factories;

import com.facens.apibonvoyage.application.dtos.hotel.HotelDTO;
import com.facens.apibonvoyage.application.dtos.hotel.HotelInsertDTO;
import com.facens.apibonvoyage.application.dtos.hotel.HotelUpdateDTO;
import com.facens.apibonvoyage.domain.entities.Hotel;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class HotelFatory {

    public static HotelDTO createFromEntity(Hotel hotel){
        return HotelDTO.builder()
                .id(hotel.getId())
                .nome(hotel.getNome())
                .endereco(hotel.getEndereco())
                .estado(hotel.getEstado())
                .estrelas(hotel.getEstrelas())
                .quartos(nonNull(hotel.getQuartos()) ?
                        hotel.getQuartos().stream().map(QuartoFactory::createFromEntity).collect(Collectors.toList()) : new ArrayList<>())
                .build();
    }

    public static Hotel createFromInsert(HotelInsertDTO dto){
        return Hotel.builder()
                .nome(dto.getNome())
                .endereco(dto.getEndereco())
                .estado(dto.getEstado())
                .estrelas(dto.getEstrelas())
                .build();
    }

    public static Hotel createFromUpdate(HotelUpdateDTO dto, HotelDTO hotel){
        return Hotel.builder()
                .id(hotel.getId())
                .nome(nonNull(dto.getNome()) ? dto.getNome() : hotel.getNome())
                .endereco(nonNull(dto.getEndereco()) ? dto.getEndereco() : hotel.getNome())
                .estado(nonNull(dto.getEstado()) ? dto.getEstado() : hotel.getNome())
                .estrelas(nonNull(dto.getEstrelas()) ? dto.getEstrelas() : hotel.getEstrelas())
                .build();
    }
}

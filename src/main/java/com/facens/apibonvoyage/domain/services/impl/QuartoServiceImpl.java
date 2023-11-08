package com.facens.apibonvoyage.domain.services.impl;

import com.facens.apibonvoyage.application.dtos.quarto.QuartoDTO;
import com.facens.apibonvoyage.application.dtos.quarto.QuartoInsertDTO;
import com.facens.apibonvoyage.application.dtos.quarto.QuartoUpdateDTO;
import com.facens.apibonvoyage.application.exceptions.BadRequestException;
import com.facens.apibonvoyage.domain.entities.Hotel;
import com.facens.apibonvoyage.domain.entities.Quarto;
import com.facens.apibonvoyage.domain.factories.QuartoFactory;
import com.facens.apibonvoyage.domain.services.QuartoService;
import com.facens.apibonvoyage.infrastrucutre.repositories.HotelRepository;
import com.facens.apibonvoyage.infrastrucutre.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuartoServiceImpl implements QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelRepository hotelRepository;

    private final String MESSAGE_ROOM_NOT_FOUND = "Quarto não encontrado";
    private final String MESSAGE_HOTEL_NOT_FOUND = "Hotel não encontrado";

    @Override
    public QuartoDTO findByIdAndHotel(UUID roomId, UUID hotelId) {
        Optional<Quarto> quarto = quartoRepository.findByIdAndHotelId(roomId, hotelId);
        if(quarto.isPresent()){
            return QuartoFactory.createFromEntity(quarto.get());
        } else{
            throw new BadRequestException(MESSAGE_ROOM_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public QuartoDTO save(UUID hotelId, QuartoInsertDTO room) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        if(hotel.isPresent()){
            Quarto quarto = QuartoFactory.createFromInsert(room, hotel.get());
            quartoRepository.save(quarto);
            return QuartoFactory.createFromEntity(quarto);
        } else{
            throw new BadRequestException(MESSAGE_HOTEL_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public QuartoDTO update(UUID hotelId, UUID roomId, QuartoUpdateDTO room) {
        Optional<Quarto> quarto = quartoRepository.findByIdAndHotelId(roomId, hotelId);
        if(quarto.isPresent()){
            Quarto quartoo = new Quarto();
            quartoRepository.save(quartoo);
            return QuartoFactory.createFromEntity(quartoo);
        } else{
            throw new BadRequestException(MESSAGE_ROOM_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delete(UUID hotelId, UUID roomId) {
        Quarto quarto = quartoRepository.findByIdAndHotelId(roomId, hotelId)
                .orElseThrow(() -> new BadRequestException(MESSAGE_ROOM_NOT_FOUND, HttpStatus.NOT_FOUND));
        quartoRepository.delete(quarto);
    }
}

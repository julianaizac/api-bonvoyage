package com.facens.apibonvoyage.domain.services;

import com.facens.apibonvoyage.application.dtos.quarto.QuartoDTO;
import com.facens.apibonvoyage.application.dtos.quarto.QuartoInsertDTO;
import com.facens.apibonvoyage.application.dtos.quarto.QuartoUpdateDTO;
import com.facens.apibonvoyage.domain.entities.Quarto;

import java.util.List;
import java.util.UUID;

public interface QuartoService {

    QuartoDTO findByIdAndHotel(UUID roomId, UUID hotelId);

    QuartoDTO save(UUID hotelId, QuartoInsertDTO room);

    QuartoDTO update(UUID hotelId, UUID roomId, QuartoUpdateDTO room);

    void delete(UUID hotelId, UUID roomId);
}

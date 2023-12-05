package com.facens.apibonvoyage.domain.services;

import com.facens.apibonvoyage.application.dtos.reserva.ReservaDTO;
import com.facens.apibonvoyage.application.dtos.reserva.ReservaInsertDTO;

import java.util.List;
import java.util.UUID;

public interface ReservaService {

    List<ReservaDTO> buscar();
    ReservaDTO criar(ReservaInsertDTO dto);

    ReservaDTO cancelar(UUID idReserva);

    ReservaDTO confirmar(UUID idReserva);


}

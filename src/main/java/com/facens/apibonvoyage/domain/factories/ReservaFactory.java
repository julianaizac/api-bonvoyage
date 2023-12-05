package com.facens.apibonvoyage.domain.factories;

import com.facens.apibonvoyage.application.dtos.reserva.ReservaDTO;
import com.facens.apibonvoyage.application.dtos.reserva.ReservaInsertDTO;
import com.facens.apibonvoyage.domain.entities.Quarto;
import com.facens.apibonvoyage.domain.entities.Reserva;

public class ReservaFactory {

    public static ReservaDTO createFromEntity(Reserva reserva){
        return ReservaDTO.builder()
                .reservaId(reserva.getId())
                .dataCheckIn(reserva.getDataCheckIn())
                .dataCheckOut(reserva.getDataCheckOut())
                .statusReserva(reserva.getStatusReserva().name())
                .simpleHotelDTO(HotelFatory.createSimpleHotelEntity(reserva.getQuarto().getHotel(), reserva.getQuarto()))
                .build();
    }

    public static ReservaDTO createFromEntity(Reserva reserva, Quarto quarto){
        return ReservaDTO.builder()
                .reservaId(reserva.getId())
                .simpleHotelDTO(HotelFatory.createSimpleHotelEntity(quarto.getHotel(), quarto))
                .dataCheckIn(reserva.getDataCheckIn())
                .dataCheckOut(reserva.getDataCheckOut())
                .statusReserva(reserva.getStatusReserva().name())
                .build();
    }

    public static Reserva createFromInsert(ReservaInsertDTO reserva, Quarto quarto){
        return Reserva.builder()
                .quarto(quarto)
                .dataCheckIn(reserva.getDataCheckIn())
                .dataCheckOut(reserva.getDataCheckOut())
                .build();
    }

}

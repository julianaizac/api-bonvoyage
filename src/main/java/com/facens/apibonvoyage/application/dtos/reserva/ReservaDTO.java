package com.facens.apibonvoyage.application.dtos.reserva;

import com.facens.apibonvoyage.application.dtos.hotel.SimpleHotelDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ReservaDTO {

    @JsonProperty("reserva_id")
    private UUID reservaId;
    @JsonProperty("data_check_in")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataCheckIn;
    @JsonProperty("data_check_out")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataCheckOut;
    @JsonProperty("status_reserva")
    private String statusReserva;
    @JsonProperty("hotel")
    private SimpleHotelDTO simpleHotelDTO;
}

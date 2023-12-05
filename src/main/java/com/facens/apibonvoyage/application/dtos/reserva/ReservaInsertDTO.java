package com.facens.apibonvoyage.application.dtos.reserva;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ReservaInsertDTO {

    @JsonProperty("hotel_id")
    private UUID hotelId;
    @JsonProperty("quarto_id")
    private UUID quartoId;
    @JsonProperty("data_check_in")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataCheckIn;
    @JsonProperty("data_check_out")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataCheckOut;

}

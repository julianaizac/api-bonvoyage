package com.facens.apibonvoyage.dtos.hotel;

import com.facens.apibonvoyage.dtos.quarto.QuartoDTO;
import com.facens.apibonvoyage.entities.Hotel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HotelDTO {

    private Long id;
    private String nome;
    private String endereco;
    private List<QuartoDTO> quartos;

}

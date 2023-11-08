package com.facens.apibonvoyage.application.dtos.hotel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import static com.facens.apibonvoyage.application.swagger.SwaggerConstantes.*;

@Data
public class HotelUpdateDTO {

    @Schema(description = NOME_HOTEL_DESCRICAO, example = NOME_HOTEL_EXEMPLO)
    private String nome;

    @Schema(description = ENDERECO_HOTEL_DESCRICAO, example = ENDERECO_HOTEL_EXEMPLO)
    private String endereco;

    @Schema(description = ESTADO_HOTEL_DESCRICAO, example = ESTADO_HOTEL_EXEMPLO)
    private String estado;

    @Schema(description = ESTRELAS_HOTEL_DESCRICAO, example = ESTRELAS_HOTEL_EXEMPLO)
    private Integer estrelas;

}

package com.facens.apibonvoyage.application.dtos.hotel;

import com.facens.apibonvoyage.application.dtos.quarto.QuartoDTO;
import com.facens.apibonvoyage.application.dtos.quarto.SimpleQuartoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import static com.facens.apibonvoyage.application.swagger.SwaggerConstantes.*;
import static com.facens.apibonvoyage.application.swagger.SwaggerConstantes.ESTRELAS_HOTEL_EXEMPLO;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleHotelDTO {

    @Schema(description = ID_HOTEL_DESCRICAO, example = ID_HOTEL_EXEMPLO)
    private UUID id;

    @Schema(description = NOME_HOTEL_DESCRICAO, example = NOME_HOTEL_EXEMPLO)
    private String nome;

    @Schema(description = ENDERECO_HOTEL_DESCRICAO, example = ENDERECO_HOTEL_EXEMPLO)
    private String endereco;

    @Schema(description = ESTADO_HOTEL_DESCRICAO, example = ESTADO_HOTEL_EXEMPLO)
    private String estado;

    @Schema(description = ESTRELAS_HOTEL_DESCRICAO, example = ESTRELAS_HOTEL_EXEMPLO)
    private Integer estrelas;

    @JsonProperty("quarto")
    private SimpleQuartoDTO quarto;

}

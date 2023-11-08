package com.facens.apibonvoyage.application.dtos.quarto;

import com.facens.apibonvoyage.domain.enums.CategoriaQuarto;
import com.facens.apibonvoyage.domain.enums.StatusQuarto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import static com.facens.apibonvoyage.application.swagger.SwaggerConstantes.*;

@Data
@Builder
public class QuartoDTO {

    @Schema(description = ID_QUARTO_DESCRICAO, example = ID_QUARTO_EXEMPLO)
    private UUID id;

    @Schema(description = QTD_CAMA_SOLTEIRO_QUARTO_DESCRICAO, example = QTD_CAMA_SOLTEIRO_QUARTO_EXEMPLO)
    @JsonProperty(value = "quantidade_cama_solteiro")
    private int quantidadeCamaSolteiro;

    @Schema(description = QTD_CAMA_CASAL_QUARTO_DESCRICAO, example = QTD_CAMA_CASAL_QUARTO_EXEMPLO)
    @JsonProperty(value = "quantidade_cama_casal")
    private int quantidadeCamaCasal;

    @Schema(description = QTD_CAMA_BELICHE_QUARTO_DESCRICAO, example = QTD_CAMA_BELICHE_QUARTO_EXEMPLO)
    @JsonProperty(value = "quantidade_beliche")
    private int quantidadeBeliche;

    @Schema(description = CATEGORIA_QUARTO_DESCRICAO, example = CATEGORIA_QUARTO_EXEMPLO)
    private CategoriaQuarto categoria;

    @Schema(description = STATUS_QUARTO_DESCRICAO, example = STATUS_QUARTO_EXEMPLO)
    private StatusQuarto statusQuarto;

    @Schema(description = ID_HOTEL_QUARTO_DESCRICAO, example = ID_HOTEL_QUARTO_EXEMPLO)
    private UUID hotelId;

}

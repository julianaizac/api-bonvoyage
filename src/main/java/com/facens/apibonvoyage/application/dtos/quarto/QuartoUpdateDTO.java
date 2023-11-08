package com.facens.apibonvoyage.application.dtos.quarto;

import io.swagger.v3.oas.annotations.media.Schema;

import static com.facens.apibonvoyage.application.swagger.SwaggerConstantes.*;
import static com.facens.apibonvoyage.application.swagger.SwaggerConstantes.QTD_CAMA_BELICHE_QUARTO_EXEMPLO;

public class QuartoUpdateDTO {

    @Schema(description = QTD_CAMA_SOLTEIRO_QUARTO_DESCRICAO, example = QTD_CAMA_SOLTEIRO_QUARTO_EXEMPLO)
    private int quantidadeCamaSolteiro;

    @Schema(description = QTD_CAMA_CASAL_QUARTO_DESCRICAO, example = QTD_CAMA_CASAL_QUARTO_EXEMPLO)
    private int quantidadeCamaCasal;

    @Schema(description = QTD_CAMA_BELICHE_QUARTO_DESCRICAO, example = QTD_CAMA_BELICHE_QUARTO_EXEMPLO)
    private int quantidadeBeliche;

}

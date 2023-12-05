package com.facens.apibonvoyage.domain.factories;

import com.facens.apibonvoyage.application.dtos.quarto.QuartoDTO;
import com.facens.apibonvoyage.application.dtos.quarto.QuartoInsertDTO;
import com.facens.apibonvoyage.application.dtos.quarto.SimpleQuartoDTO;
import com.facens.apibonvoyage.domain.entities.Hotel;
import com.facens.apibonvoyage.domain.entities.Quarto;
import com.facens.apibonvoyage.domain.enums.CategoriaQuarto;
import com.facens.apibonvoyage.domain.enums.StatusQuarto;

public class QuartoFactory {
    public static QuartoDTO createFromEntity(Quarto quarto) {
        return QuartoDTO.builder()
                .id(quarto.getId())
                .quantidadeCamaSolteiro(quarto.getQuantidadeCamaSolteiro())
                .quantidadeCamaCasal(quarto.getQuantidadeCamaCasal())
                .quantidadeBeliche(quarto.getQuantidadeBeliche())
                .categoria(quarto.getCategoria())
                .statusQuarto(quarto.getStatusQuarto())
                .hotelId(quarto.getHotel().getId())
                .preco(quarto.getPreco())
                .build();
    }

    public static Quarto createFromInsert(QuartoInsertDTO dto, Hotel hotel){
        return Quarto.builder()
                .quantidadeCamaSolteiro(dto.getQuantidadeCamaSolteiro())
                .quantidadeCamaCasal(dto.getQuantidadeCamaCasal())
                .quantidadeBeliche(dto.getQuantidadeBeliche())
                .categoria(CategoriaQuarto.valueOf(dto.getCategoria()))
                .statusQuarto(StatusQuarto.DISPONIVEL)
                .hotel(hotel)
                .preco(dto.getPreco())
                .build();
    }

    public static SimpleQuartoDTO createSimpleQuartoEntity(Quarto quarto) {
        return SimpleQuartoDTO.builder()
                .id(quarto.getId())
                .quantidadeCamaSolteiro(quarto.getQuantidadeCamaSolteiro())
                .quantidadeCamaCasal(quarto.getQuantidadeCamaCasal())
                .quantidadeBeliche(quarto.getQuantidadeBeliche())
                .categoria(quarto.getCategoria())
                .statusQuarto(quarto.getStatusQuarto())
                .preco(quarto.getPreco())
                .build();
    }
}

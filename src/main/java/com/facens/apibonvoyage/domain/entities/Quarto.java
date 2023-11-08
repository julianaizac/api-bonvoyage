package com.facens.apibonvoyage.domain.entities;

import com.facens.apibonvoyage.domain.enums.CategoriaQuarto;
import com.facens.apibonvoyage.domain.enums.StatusQuarto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_QUARTO")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Double preco;

    private int quantidadeCamaSolteiro;
    private int quantidadeCamaCasal;
    private int quantidadeBeliche;

    @Enumerated(EnumType.STRING)
    private CategoriaQuarto categoria;

    @Enumerated(EnumType.STRING)
    private StatusQuarto statusQuarto;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
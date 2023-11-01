package com.facens.apibonvoyage.entities;

import com.facens.apibonvoyage.enums.CategoriaQuarto;
import jakarta.persistence.*;

@Entity
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidadeCamaSolteiro;
    private int quantidadeCamaCasal;
    private int quantidadeBeliche;

    @Enumerated(EnumType.STRING)
    private CategoriaQuarto categoria;
    private String status;

    @ManyToOne
    private Hotel hotel;

}
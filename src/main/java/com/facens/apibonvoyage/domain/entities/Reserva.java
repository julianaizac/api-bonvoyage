package com.facens.apibonvoyage.domain.entities;

import com.facens.apibonvoyage.domain.enums.StatusQuarto;
import com.facens.apibonvoyage.domain.enums.StatusReserva;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    @Enumerated(EnumType.STRING)
    private StatusReserva statusReserva;

}

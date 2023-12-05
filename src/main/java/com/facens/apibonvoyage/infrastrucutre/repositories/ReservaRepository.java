package com.facens.apibonvoyage.infrastrucutre.repositories;

import com.facens.apibonvoyage.domain.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, UUID> {
}

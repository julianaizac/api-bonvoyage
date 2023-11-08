package com.facens.apibonvoyage.infrastrucutre.repositories;

import com.facens.apibonvoyage.domain.entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, UUID> {
    Optional<Quarto> findByIdAndHotelId(UUID roomId, UUID hotelId);

}

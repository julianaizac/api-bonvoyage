package com.facens.apibonvoyage.infrastrucutre.repositories;

import com.facens.apibonvoyage.domain.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {
}

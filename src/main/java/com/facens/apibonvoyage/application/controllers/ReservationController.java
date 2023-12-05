package com.facens.apibonvoyage.application.controllers;

import com.facens.apibonvoyage.application.dtos.reserva.ReservaDTO;
import com.facens.apibonvoyage.application.dtos.reserva.ReservaInsertDTO;
import com.facens.apibonvoyage.domain.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hoteis/reservas")
public class ReservationController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> buscar(){
        List<ReservaDTO> list = service.buscar();
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> criar(@RequestBody ReservaInsertDTO dto) {
        ReservaDTO newDto = service.criar(dto);
        return ResponseEntity.ok(newDto);
    }

    @PatchMapping("/{idReserva}/cancelar")
    public ResponseEntity<ReservaDTO> cancelar(@PathVariable UUID idReserva){
        ReservaDTO reservaDTO = service.cancelar(idReserva);
        return ResponseEntity.ok(reservaDTO);
    }

    @PatchMapping("/{idReserva}/confirmar")
    public ResponseEntity<ReservaDTO> confirmar(@PathVariable UUID idReserva){
        ReservaDTO reservaDTO = service.confirmar(idReserva);
        return ResponseEntity.ok(reservaDTO);
    }


}

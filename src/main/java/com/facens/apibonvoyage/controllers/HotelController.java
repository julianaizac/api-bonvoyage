package com.facens.apibonvoyage.controllers;

import com.facens.apibonvoyage.dtos.hotel.HotelDTO;
import com.facens.apibonvoyage.dtos.hotel.HotelInsertDTO;
import com.facens.apibonvoyage.dtos.hotel.HotelUpdateDTO;
import com.facens.apibonvoyage.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService service;

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAll() {
        List<HotelDTO> list = service.getAllHotels();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getById(@PathVariable Long id) {
        HotelDTO dto = service.getHotelById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<HotelDTO> insert(@RequestBody HotelInsertDTO dto) {
        HotelDTO newDto = service.insertHotel(dto);
        return ResponseEntity.ok(newDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDTO> update(@PathVariable Long id, @RequestBody HotelUpdateDTO dto) {
        HotelDTO updatedDto = service.updateHotel(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

}


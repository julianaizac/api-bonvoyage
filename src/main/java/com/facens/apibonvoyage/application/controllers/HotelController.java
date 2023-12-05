package com.facens.apibonvoyage.application.controllers;

import com.facens.apibonvoyage.application.dtos.hotel.HotelDTO;
import com.facens.apibonvoyage.application.dtos.hotel.HotelInsertDTO;
import com.facens.apibonvoyage.application.dtos.hotel.HotelUpdateDTO;
import com.facens.apibonvoyage.domain.services.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.facens.apibonvoyage.application.swagger.SwaggerConstantes.*;
import static com.facens.apibonvoyage.application.swagger.SwaggerConstantes.GET_HOTEL_DESCRIPTION;

@RestController
@RequestMapping("/hoteis")
@Tag(name = NOME_CONTROLLER_HOTEL, description = DESCRICAO_CONTROLLER_HOTEL)
public class HotelController {

    @Autowired
    private HotelService service;

    @Operation(summary = GET_HOTEL, description = GET_HOTEL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = HotelDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "204", description = "Não tem hotéis cadastrados",
                    content = { @Content(schema = @Schema()) })
    })
    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAll() {
        List<HotelDTO> list = service.getAllHotels();
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }

    @Operation(summary = GET_HOTEL_BY_ID, description = GET_HOTEL_BY_ID_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = HotelDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Hotel não encontrado.",
                    content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getById(@PathVariable UUID id) {
        HotelDTO dto = service.getHotelById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = POST_HOTEL, description = POST_HOTEL_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = { @Content(schema = @Schema(implementation = HotelDTO.class), mediaType = "application/json") })
    })
    @PostMapping
    public ResponseEntity<HotelDTO> insert(@RequestBody HotelInsertDTO dto) {
        HotelDTO newDto = service.insertHotel(dto);
        return ResponseEntity.ok(newDto);
    }

    @Operation(summary = PATCH_HOTEL_BY_ID, description = PATCH_HOTEL_BY_ID_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = HotelDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Hotel não encontrado.",
                    content = { @Content(schema = @Schema()) })
    })
    @PatchMapping("/{id}")
    public ResponseEntity<HotelDTO> update(@PathVariable UUID id, @RequestBody HotelUpdateDTO dto) {
        HotelDTO updatedDto = service.updateHotel(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @Operation(summary = DELETE_HOTEL_BY_ID, description = DELETE_HOTEL_BY_ID_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = HotelDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Hotel não encontrado.",
                    content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

}


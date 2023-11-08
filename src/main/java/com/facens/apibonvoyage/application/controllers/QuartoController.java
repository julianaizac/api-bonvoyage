package com.facens.apibonvoyage.application.controllers;

import com.facens.apibonvoyage.application.dtos.hotel.HotelDTO;
import com.facens.apibonvoyage.application.dtos.quarto.QuartoDTO;
import com.facens.apibonvoyage.application.dtos.quarto.QuartoInsertDTO;
import com.facens.apibonvoyage.application.dtos.quarto.QuartoUpdateDTO;
import com.facens.apibonvoyage.domain.services.QuartoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.facens.apibonvoyage.application.swagger.SwaggerConstantes.*;

@RestController
@RequestMapping("/hotels/{hotelId}/rooms")
@Tag(name = NOME_CONTROLLER_QUARTO, description = DESCRICAO_CONTROLLER_QUARTO)
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @Operation(summary = GET_QUARTO_BY_ID, description = GET_QUARTO_BY_ID_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = QuartoDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado",
                    content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{roomId}")
    public ResponseEntity<QuartoDTO> getRoomById(@PathVariable UUID hotelId, @PathVariable UUID roomId) {
        return ResponseEntity.ok(quartoService.findByIdAndHotel(roomId, hotelId));
    }

    @Operation(summary = POST_QUARTO, description = POST_QUARTO_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = { @Content(schema = @Schema(implementation = HotelDTO.class), mediaType = "application/json") })
    })
    @PostMapping
    public ResponseEntity<QuartoDTO> createRoom(@PathVariable UUID hotelId, @RequestBody QuartoInsertDTO room) {
        return ResponseEntity.ok(quartoService.save(hotelId, room));
    }

    @Operation(summary = PATCH_QUARTO_BY_ID, description = PATCH_QUARTO_BY_ID_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = HotelDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado.",
                    content = { @Content(schema = @Schema()) })
    })
    @PatchMapping("/{roomId}")
    public ResponseEntity<QuartoDTO> updateRoom(@PathVariable UUID hotelId, @PathVariable UUID roomId, @RequestBody QuartoUpdateDTO room) {
        return ResponseEntity.ok(quartoService.update(hotelId, roomId, room));
    }
    @Operation(summary = DELETE_QUARTO_BY_ID, description = DELETE_QUARTO_BY_ID_DESCRIPTION)
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = HotelDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado.",
                    content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable UUID hotelId, @PathVariable UUID roomId) {
        quartoService.delete(hotelId, roomId);
        return ResponseEntity.noContent().build();
    }

}
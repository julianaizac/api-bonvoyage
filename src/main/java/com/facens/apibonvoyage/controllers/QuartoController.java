package com.facens.apibonvoyage.controllers;

import com.facens.apibonvoyage.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels/{hotelId}/rooms")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

}
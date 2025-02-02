package com.ambiSense.AmbiSense.controller;

import com.ambiSense.AmbiSense.model.Lectura;
import com.ambiSense.AmbiSense.service.LecturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datos")
@CrossOrigin(origins = "*")
public class DatosController {

    private final LecturaService lecturaService;

    public DatosController(LecturaService lecturaService) {
        this.lecturaService = lecturaService;
    }

    @PostMapping(value="/upload", consumes = "application/json")
    public ResponseEntity<String> recibirDatos(@RequestBody List<Lectura> lecturas) {
        for (Lectura lectura : lecturas) {
            lecturaService.saveLectura(lectura);
        }
        return ResponseEntity.ok("{\"mensaje\": \"Datos recibidos correctamente\"}");
    }
}
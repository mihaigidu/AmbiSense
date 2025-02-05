package com.ambiSense.AmbiSense.controller;

import com.ambiSense.AmbiSense.model.Lectura;
import com.ambiSense.AmbiSense.service.LecturaService;
import com.ambiSense.AmbiSense.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lecturas")
@CrossOrigin(origins = "*") //Permite solicitudes de cualquier origen
public class LecturaController {

    @Autowired
    private LecturaService lecturaService;

    private SensorService sensorService;

    @GetMapping
    public List<Lectura> findAll() {return lecturaService.findAll();}

    @GetMapping("/{dia}")
    public List<Lectura> findByDay(@PathVariable String dia) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate filterDate = LocalDate.parse(dia, formatter);

        return lecturaService.findAll().stream()
                .filter(l -> l.getDateLectura().toLocalDate().equals(filterDate))
                .collect(Collectors.toList());
    }

    @PostMapping(value="/upload", consumes = "application/json")
    public ResponseEntity<String> guardarDatos(@RequestBody List<Lectura> lecturas) {
        for (Lectura lectura : lecturas) {
            lecturaService.saveLectura(lectura);
        }
        return ResponseEntity.ok("{\"mensaje\": \"Datos recibidos correctamente\"}");
    }

    @PostMapping(value="/upload/{idSensor}", consumes = "application/json")
    public ResponseEntity<String> recibirDatos(@RequestBody List<Lectura> lecturas, @PathVariable Long idSensor) {
        for (Lectura lectura : lecturas) {
            lecturaService.saveLecturaConId(lectura, idSensor);
        }
        return ResponseEntity.ok("{\"mensaje\": \"Datos recibidos correctamente\"}");
    }



}

package com.ambiSense.AmbiSense.controller;

import com.ambiSense.AmbiSense.model.Sensor;
import com.ambiSense.AmbiSense.model.Lectura;
import com.ambiSense.AmbiSense.service.LecturaService;
import com.ambiSense.AmbiSense.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sensores")
@CrossOrigin(origins = "*")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private LecturaService lecturaService;

    // Obtener todos los sensores
    @GetMapping
    public ResponseEntity<List<Sensor>> getAllSensores() {
        List<Sensor> sensores = sensorService.findAll();
        return ResponseEntity.ok(sensores);
    }

    // Obtener un sensor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable Long id) {
        Optional<Sensor> sensor = sensorService.findById(id);
        return sensor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //lecturas de un sensor {id} y lecturas por fecha
    @GetMapping("/{id}/lecturas/{fecha}")
    public ResponseEntity<List<Lectura>> getLecturasBySensorAndDay(
            @PathVariable Long id, @PathVariable String fecha) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate filterDate = LocalDate.parse(fecha, formatter);

        List<Lectura> lecturas = lecturaService.findBySensorAndDay(id, filterDate);

        if (lecturas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lecturas);
    }



    // Agregar un nuevo sensor
    @PostMapping(value = "/upload", consumes = "application/json")
    public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor) {
        Sensor nuevoSensor = sensorService.save(sensor);
        return ResponseEntity.ok(nuevoSensor);
    }

    // Eliminar un sensor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        if (sensorService.findById(id).isPresent()) {
            sensorService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

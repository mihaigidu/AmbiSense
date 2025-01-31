package com.ambiSense.AmbiSense.controller;

import com.ambiSense.AmbiSense.model.Lectura;
import com.ambiSense.AmbiSense.service.LecturaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Lectura> findAll() {return lecturaService.findAll();}

    @GetMapping("/{dia}")
    public List<Lectura> findByDay(@PathVariable String dia) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate filterDate = LocalDate.parse(dia, formatter);

        List<Lectura> listByDay = lecturaService.findAll().stream()
                .filter(l -> l.getDateLectura().toLocalDate().equals(filterDate))
                .collect(Collectors.toList());

        return listByDay;
    }

//    @GetMapping("/{ubicacion}")
//    public List<Lectura> findByUbication(@PathVariable String ubicacion) {
//        return lecturaService.findByUbication(ubicacion);
//    }

}

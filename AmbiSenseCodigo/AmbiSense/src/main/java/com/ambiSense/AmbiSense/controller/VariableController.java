package com.ambiSense.AmbiSense.controller;

import com.ambiSense.AmbiSense.model.Variable;
import com.ambiSense.AmbiSense.service.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variables")
@CrossOrigin(origins = "*") //Permite solicitudes de cualquier origen
public class VariableController {
    @Autowired
    private VariableService variableService;

    @GetMapping
    public List<Variable> findAll() {return variableService.findAll();}


}

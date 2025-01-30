package com.ambiSense.AmbiSense.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class VisualizacionController {
    @GetMapping("/Inicio")
    public RedirectView redirigirAInicio() {
        return new RedirectView("/Main.html"); // Redirige al archivo en /static/
    }
}

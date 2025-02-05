package com.ambiSense.AmbiSense.controller;

import com.ambiSense.AmbiSense.model.Usuario;
import com.ambiSense.AmbiSense.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

//    @GetMapping
//    public List<Usuario> findAll(){ return usuarioService.findAll();
//    }

    @PostMapping("/save")
    public void saveUsuario(){

    }
}

package com.ambiSense.AmbiSense.controller;

import com.ambiSense.AmbiSense.model.Usuario;
import com.ambiSense.AmbiSense.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return "Error: El usuario ya existe";
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // Encripta la contraseña

        if (usuario.getRol() == null) {
            usuario.setRol(Usuario.Rol.ALUMNO); // Por defecto, todos los usuarios son ALUMNOS
        }

        usuarioRepository.save(usuario);
        return "Usuario registrado con éxito como " + usuario.getRol();
    }

    @GetMapping("/login")
    public String login() {
        return "Por favor, inicie sesión"; // Spring maneja la autenticación automáticamente
    }
}

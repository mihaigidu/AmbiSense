package com.ambiSense.AmbiSense.service;

import com.ambiSense.AmbiSense.model.Usuario;
import com.ambiSense.AmbiSense.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository ;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
        }

        Usuario usuario = usuarioOpt.get();

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword()) // La contraseña debe estar encriptada
                .roles(usuario.getRol().getName()) // Si tienes un sistema de roles
                .build();
    }
}

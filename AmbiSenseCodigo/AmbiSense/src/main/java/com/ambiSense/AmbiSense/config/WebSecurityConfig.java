package com.ambiSense.AmbiSense.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactivar CSRF para permitir peticiones desde Postman/Frontend
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // Permitir acceso sin autenticación
                        .requestMatchers("/public/**").permitAll() // Si tienes otros endpoints públicos
                        .requestMatchers("/sensores/**").permitAll()
                        .requestMatchers("/lecturas/**").permitAll()// Permitir acceso a todos los endpoints de sensores
                        .anyRequest().authenticated() // Proteger los demás endpoints
                )
                .httpBasic(httpBasic -> httpBasic.disable()) // Desactivar autenticación básica
                .sessionManagement(session -> session.disable()); // API sin sesiones

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
package com.ambiSense.AmbiSense.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean loggedIn; //Para saber si el usuario esta conectado o no

    @Column(name = "log_date")
    private LocalDateTime logDate;

    // Relación muchos a uno con Rol
    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    // Relación muchos a muchos con Sensor "Tabla Intermedia"
    @ManyToMany
    @JoinTable(
            name = "sensor_usuario",  // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "id_user"),  // Columna que hace referencia a Usuario
            inverseJoinColumns = @JoinColumn(name = "id_sensor")  // Columna que hace referencia a Sensor
    )
    private Set<Sensor> sensores = new HashSet<>();

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Set<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(Set<Sensor> sensores) {
        this.sensores = sensores;
    }
}

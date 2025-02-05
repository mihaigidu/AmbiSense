package com.ambiSense.AmbiSense.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sensor")
public class  Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String ubication;
    private String type;
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Lectura> lecturas = new HashSet<>();

    @ManyToMany(mappedBy = "sensores")
    private Set<Usuario> usuarios = new HashSet<>();

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Alerta> alertas = new HashSet<>();

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long idSensor) {
        this.id = idSensor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(Set<Alerta> alertas) {
        this.alertas = alertas;
    }

    public Set<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(Set<Lectura> lecturas) {
        this.lecturas = lecturas;
    }
}

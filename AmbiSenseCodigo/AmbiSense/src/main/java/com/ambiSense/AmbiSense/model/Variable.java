package com.ambiSense.AmbiSense.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "variable")
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String unity;

    @OneToMany(mappedBy = "variable", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Lectura> lecturas;

    @OneToMany(mappedBy = "variable", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Alerta> alertas;

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

    public String getUnity() {
        return unity;
    }

    public void setUnity(String value) {
        this.unity = value;
    }

    public Set<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(Set<Lectura> lecturas) {
        this.lecturas = lecturas;
    }

    public Set<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(Set<Alerta> alertas) {
        this.alertas = alertas;
    }
}

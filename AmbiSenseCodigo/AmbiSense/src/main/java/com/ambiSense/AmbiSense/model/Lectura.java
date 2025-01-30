package com.ambiSense.AmbiSense.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "lectura")
public class Lectura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime dateLectura;

    @OneToMany(mappedBy = "lectura", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference//Permite la serialización de esta lista
    private List<VariableLectura> variables;

    public Lectura() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateLectura() {
        return dateLectura;
    }

    public void setDateLectura(LocalDateTime dateLectura) {
        this.dateLectura = dateLectura;
    }

    public List<VariableLectura> getVariables() {
        return variables;
    }

    public void setVariables(List<VariableLectura> variables) {
        this.variables = variables;
    }
}
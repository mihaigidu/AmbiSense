package com.ambiSense.AmbiSense.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "lectura")
public class Lectura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ElementCollection
//    @CollectionTable(name = "lectura_variables", joinColumns = @JoinColumn(name = "lectura_id"))
//    @MapKeyColumn(name = "nombre_variable")
//    @Column(name = "valor")
//    private Map<String, Double> variables; // Mapea el nombre de la variable con su valor

    private double valor;

    @Column(name = "date")
    private LocalDateTime dateLectura;

    @ManyToOne
    @JoinColumn(name = "id_variable")
    private Variable variable;

//    @ManyToOne
//    @JoinColumn(name = "id_sensor")
//    private Sensor sensor;

    public Lectura() {}


    public Long getId() {
        return id;
    }

    public void setId(Long idLectura) {
        this.id = idLectura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDateLectura() {
        return dateLectura;
    }

    public void setDateLectura(LocalDateTime dateLectura) {
        this.dateLectura = dateLectura;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }
}

package com.ambiSense.AmbiSense.model;

import jakarta.persistence.*;

@Entity
@Table(name = "variable")
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String unity;


    public Long getIdVariable() {
        return id;
    }

    public void setIdVariable(Long id) {
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
}

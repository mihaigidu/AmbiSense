package com.ambiSense.AmbiSense.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

//    @Column(nullable = false)
    private boolean loggedIn; // Indica si el usuario está conectado o no

//    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt; // Fecha de creación del usuario

    @ManyToMany
    @JoinTable(
            name = "sensor_usuario",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_sensor")
    )
    private Set<Sensor> sensores = new HashSet<>();

    public enum Rol {
        ADMIN, ALUMNO;
    }

    // Constructores
    public Usuario() {
        this.createdAt = LocalDateTime.now(); // Se asigna la fecha de creación automáticamente
    }

    public Usuario(String name, String email, String password, Rol rol) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.createdAt = LocalDateTime.now();
        this.loggedIn = false;
    }

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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(Set<Sensor> sensores) {
        this.sensores = sensores;
    }

    // Métodos toString, equals y hashCode
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                ", loggedIn=" + loggedIn +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id) && email.equals(usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}

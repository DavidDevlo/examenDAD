package com.example.dnausuario.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;  // Alumno o Docente

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado = EstadoUsuario.ACTIVO;  // Por defecto, activo

    private String carrera;

    @Email(message = "El correo no es válido")
    @Column(unique = true, nullable = false)  // Validación de correo único
    private String correo;

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Enumeración TipoUsuario (Alumno o Docente)
    public enum TipoUsuario {
        ALUMNO,
        DOCENTE
    }

    // Enumeración EstadoUsuario (Activo o Inactivo)
    public enum EstadoUsuario {
        ACTIVO,
        INACTIVO
    }
}

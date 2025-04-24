package com.example.dnaprestamo.entity;

import com.example.dnaprestamo.dto.LibroDto;
import com.example.dnaprestamo.dto.UsuarioDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK al Libro Service
    @Column(nullable = false)
    private Long libroId;

    // FK al Usuario Service
    @Column(nullable = false)
    private Integer usuarioId;

    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @PrePersist
    public void prePersist() {
        if (fechaPrestamo == null) {
            fechaPrestamo = LocalDate.now();
        }
    }

    private LocalDate fechaDevolucion;

    // Transient DTOs para comunicación con otros microservicios
    @Transient
    private LibroDto libroDto;

    @Transient
    private UsuarioDto usuarioDto;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public LibroDto getLibroDto() {
        return libroDto;
    }

    public void setLibroDto(LibroDto libroDto) {
        this.libroDto = libroDto;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }
}


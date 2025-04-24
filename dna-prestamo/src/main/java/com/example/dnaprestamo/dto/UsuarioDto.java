package com.example.dnaprestamo.dto;

public  class UsuarioDto {
    private Integer id;
    private String nombre;
    private String tipo;
    private String estado;
    private String carrera;
    private String correo;
    // getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
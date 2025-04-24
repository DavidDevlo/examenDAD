package com.example.dnalibro.Servicio;

import com.example.dnalibro.Entidad.Libro;


import java.util.List;
import java.util.Optional;

public interface  LibroService {
    public List<Libro> listar();
    public Libro guardar(Libro libro);
    public Libro actualizar(Libro libro);
    public Optional<Libro> listarPorId(Integer id);
    public void eliminarPorId(Integer id);
}
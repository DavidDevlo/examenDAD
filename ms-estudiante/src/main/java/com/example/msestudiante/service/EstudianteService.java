package com.example.msestudiante.service;

import com.example.msestudiante.entity.Estudiante;
import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    public List<Estudiante> listar();
    public Estudiante guardar(Estudiante estudiante);
    public Estudiante actualizar(Estudiante estudiante);
    public Optional<Estudiante> listarPorId(Integer id);
    public void eliminarPorId(Integer id);
}

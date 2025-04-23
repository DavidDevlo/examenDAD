package com.example.mscurso.service;

import com.example.mscurso.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();
    Curso guardar(Curso curso);
    Curso actualizar(Curso curso);
    Optional<Curso> listarPorId(Integer id);
    void eliminarPorId(Integer id);
}

package com.example.mscurso.service.impl;

import com.example.mscurso.entity.Curso;
import com.example.mscurso.repository.CursoRepository;
import com.example.mscurso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Optional<Curso> listarPorId(Integer id) {
        return cursoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        cursoRepository.deleteById(id);
    }
}

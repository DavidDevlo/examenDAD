package com.example.mscurso.repository;

import com.example.mscurso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Optional<Curso> findByNombre(String nombre);
}

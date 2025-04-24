package com.example.dnaprestamo.repository;

import com.example.dnaprestamo.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    List<Prestamo> findByUsuarioId(Integer usuarioId);

    // Cuenta los préstamos activos (sin devolver) de un usuario
    int countByUsuarioIdAndFechaDevolucionIsNull(Integer usuarioId);

    // Verifica si un libro está actualmente prestado (préstamo sin devolución)
    boolean existsByLibroIdAndFechaDevolucionIsNull(Long libroId);


}
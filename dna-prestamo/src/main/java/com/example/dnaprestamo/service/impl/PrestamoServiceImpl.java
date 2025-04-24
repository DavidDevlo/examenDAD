package com.example.dnaprestamo.service.impl;

import com.example.dnaprestamo.dto.LibroDto;
import com.example.dnaprestamo.dto.UsuarioDto;
import com.example.dnaprestamo.entity.Prestamo;
import com.example.dnaprestamo.feing.LibroClient;
import com.example.dnaprestamo.feing.UsuarioClient;
import com.example.dnaprestamo.repository.PrestamoRepository;
import com.example.dnaprestamo.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private com.example.dnaprestamo.feing.UsuarioClient usuarioClient;

    @Autowired
    private com.example.dnaprestamo.feing.LibroClient libroClient;

    private final int MAX_PRESTAMOS = 3;

    @Override
    public List<Prestamo> listar() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo guardar(Prestamo prestamo) {
        // 1) Verificar usuario activo
        UsuarioDto usuario = usuarioClient
                .obtenerUsuarioPorId(prestamo.getUsuarioId())
                .getBody();
        if (!"ACTIVO".equalsIgnoreCase(usuario.getEstado())) {
            throw new RuntimeException("El usuario no está activo");
        }

        // 2) Validar límite de préstamos activos
        int prestamosActivos = prestamoRepository
                .countByUsuarioIdAndFechaDevolucionIsNull(prestamo.getUsuarioId());
        if (prestamosActivos >= MAX_PRESTAMOS) {
            throw new RuntimeException("El usuario ya tiene el máximo de préstamos activos");
        }

        // 3) Verificar disponibilidad del libro
        boolean libroPrestado = prestamoRepository
                .existsByLibroIdAndFechaDevolucionIsNull(prestamo.getLibroId());
        if (libroPrestado) {
            throw new RuntimeException("El libro no está disponible");
        }

        // 4) Registrar el préstamo
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo actualizar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Optional<Prestamo> listarPorId(Integer id) {
        return prestamoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        prestamoRepository.deleteById(id);
    }
}

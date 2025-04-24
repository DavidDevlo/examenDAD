package com.example.dnaprestamo.service;

import com.example.dnaprestamo.entity.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoService {
    public List<Prestamo> listar();
    public Prestamo guardar(Prestamo prestamo);
    public Prestamo actualizar(Prestamo prestamo);
    public Optional<Prestamo> listarPorId(Integer id);
    public void eliminarPorId(Integer id);
}
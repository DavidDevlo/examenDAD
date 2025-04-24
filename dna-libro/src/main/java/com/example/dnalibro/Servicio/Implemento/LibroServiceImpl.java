package com.example.dnalibro.Servicio.Implemento;

import com.example.dnalibro.Entidad.Libro;
import com.example.dnalibro.Repositorio.LibroRepository;
import com.example.dnalibro.Servicio.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardar(Libro libro) {
        if (libroRepository.existsByIsbn(libro.getIsbn())) {
            throw new IllegalArgumentException("El ISBN ya está registrado: " + libro.getIsbn());
        }
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizar(Libro libro) {
        Optional<Libro> libroExistente = libroRepository.findById(libro.getId());
        if (libroExistente.isEmpty()) {
            throw new IllegalArgumentException("El libro no existe con ID: " + libro.getId());
        }

        // Si cambia el ISBN, verificar que no esté duplicado
        if (!libroExistente.get().getIsbn().equals(libro.getIsbn()) &&
                libroRepository.existsByIsbn(libro.getIsbn())) {
            throw new IllegalArgumentException("Ya existe otro libro con el ISBN: " + libro.getIsbn());
        }

        return libroRepository.save(libro);
    }

    @Override
    public Optional<Libro> listarPorId(Integer id) {
        return libroRepository.findById(Long.valueOf(id));
    }

    @Override
    public void eliminarPorId(Integer id) {
        libroRepository.deleteById(Long.valueOf(id));
    }
}
package com.example.dnaprestamo.controller;

import com.example.dnaprestamo.entity.Prestamo;
import com.example.dnaprestamo.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping()
    public ResponseEntity<List<Prestamo>> list() {
        return ResponseEntity.ok().body(prestamoService.listar());
    }

    @PostMapping()
    public ResponseEntity<Prestamo> save(@RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoService.guardar(prestamo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> update(@RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoService.actualizar(prestamo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> listById(@PathVariable(required = true) Integer id) {
        Optional<Prestamo> prestamo = prestamoService.listarPorId(id);
        return prestamo.isPresent() ? ResponseEntity.ok().body(prestamo.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        prestamoService.eliminarPorId(id);
        return "Eliminación Correcta";
    }
}

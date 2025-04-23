package com.example.mscurso.controller;

import com.example.mscurso.entity.Curso;
import com.example.mscurso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listarTodos() {
        return ResponseEntity.ok(cursoService.listar());
    }

    @PostMapping
    public ResponseEntity<Curso> guardar(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.guardar(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.actualizar(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Integer id) {
        return cursoService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        cursoService.eliminarPorId(id);
        return ResponseEntity.ok("Eliminación correcta");
    }
}

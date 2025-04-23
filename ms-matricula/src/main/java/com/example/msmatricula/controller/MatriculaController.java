package com.example.msmatricula.controller;


import com.example.msmatricula.entity.Matricula;
import com.example.msmatricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private  MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> findAll() {
        return matriculaService.findAll();
    }

    @GetMapping("/{id}")
    public Matricula findById(@PathVariable int id) {
        return matriculaService.findById(id);
    }

    @PostMapping
    public Matricula create(@RequestBody Matricula matricula) {
        return matriculaService.Save(matricula);
    }

    @PutMapping
    public Matricula update(@RequestBody  Matricula matricula) {
        return matriculaService.update(matricula);
    }

}

package com.example.msmatricula.service;


import com.example.msmatricula.entity.Matricula;

import java.util.List;


public interface MatriculaService {
    List<Matricula> findAll();
    Matricula findById(int id);
    Matricula Save(Matricula matricula);
    Matricula update(Matricula matricula);
}

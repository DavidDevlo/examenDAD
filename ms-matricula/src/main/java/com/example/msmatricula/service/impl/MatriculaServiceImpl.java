package com.example.msmatricula.service.impl;


import com.example.msmatricula.entity.Matricula;
import com.example.msmatricula.feing.EstudianteFeing;
import com.example.msmatricula.repository.MatriculaRepository;
import com.example.msmatricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private EstudianteFeing estudianteFeing;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula findById(int id) {
        Matricula matricula = matriculaRepository.findById(id).get();
        matricula.setEstudianteDto(estudianteFeing.buscarEstudiante(matricula.getEstudianteId()).getBody());
        return matriculaRepository.findById(id).get();
    }

    @Override
    public Matricula Save(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula update(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }
}

package com.example.msmatricula.entity;

import com.example.msmatricula.dto.EstudianteDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.Transient;


@Data
@Entity
public class Matricula {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String estado;
        private Integer estudianteId;

        @Transient
        private EstudianteDto estudianteDto;




}

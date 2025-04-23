package com.example.msmatricula.feing;

import com.example.msmatricula.dto.EstudianteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-examen-service",path = "/estudiante")
public interface EstudianteFeing {
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> buscarEstudiante(@PathVariable Integer id);

}

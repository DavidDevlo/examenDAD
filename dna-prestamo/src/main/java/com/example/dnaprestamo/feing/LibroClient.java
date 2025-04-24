package com.example.dnaprestamo.feing;

import com.example.dnaprestamo.dto.LibroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dna-libro-service", path = "/libros")
public interface LibroClient {

    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> obtenerLibroPorId(@PathVariable Integer id);
}

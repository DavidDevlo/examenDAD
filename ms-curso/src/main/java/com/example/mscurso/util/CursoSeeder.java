package com.example.mscurso.util;

import com.example.mscurso.entity.Curso;
import com.example.mscurso.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CursoSeeder implements CommandLineRunner {

    private final CursoRepository cursoRepository;

    public CursoSeeder(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public void run(String... args) {
        // Solo seedear si la tabla está vacía
        if (cursoRepository.count() == 0) {
            Curso c1 = new Curso(null, "Matemáticas", "Álgebra y Geometría básica", "MAT101");
            Curso c2 = new Curso(null, "Historia", "Historia Universal", "HIS201");
            Curso c3 = new Curso(null, "Programación", "Java y Spring Boot", "PROG301");
            Curso c4 = new Curso(null, "Física", "Mecánica y Termodinámica", "FIS401");
            Curso c5 = new Curso(null, "Química", "Química General", "QUI501");
            Curso c6 = new Curso(null, "Biología", "Biología Celular", "BIO601");
            Curso c7 = new Curso(null, "Inglés", "Inglés Básico", "ING701");
            Curso c8 = new Curso(null, "Geografía", "Geografía Mundial", "GEO801");
            Curso c9 = new Curso(null, "Economía", "Principios de Economía", "ECO901");
            Curso c10 = new Curso(null, "Arte", "Historia del Arte", "ART1001");

            cursoRepository.save(c1);
            cursoRepository.save(c2);
            cursoRepository.save(c3);
            cursoRepository.save(c4);
            cursoRepository.save(c5);
            cursoRepository.save(c6);
            cursoRepository.save(c7);
            cursoRepository.save(c8);
            cursoRepository.save(c9);
            cursoRepository.save(c10);

            System.out.println("[Seeder] Cursos insertados correctamente.");
        } else {
            System.out.println("[Seeder] Ya existen cursos, no se realizó inserción.");
        }
    }
}

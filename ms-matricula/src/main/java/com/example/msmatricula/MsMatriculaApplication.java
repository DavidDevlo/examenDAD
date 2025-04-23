package com.example.msmatricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.msmatricula.feing") // asegúrate del paquete correcto
public class MsMatriculaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsMatriculaApplication.class, args);
    }
}

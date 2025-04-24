package com.example.dnaprestamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.dnaprestamo.feing")
public class DnaPrestamoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DnaPrestamoApplication.class, args);
    }

}

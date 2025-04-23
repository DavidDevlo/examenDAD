package com.example.msestudiante.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
//@Data
public class Estudiante {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nombre;
        private String apellido;
        private String numero;

        public Estudiante() {

        }


        public String getNumero() {
                return numero;
        }

        public void setNumero(String numero) {
                this.numero = numero;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getApellido() {
                return apellido;
        }

        public void setApellido(String apellido) {
                this.apellido = apellido;
        }

        public Estudiante(Integer id, String numero, String apellido, String nombre) {
                this.id = id;
                this.numero = numero;
                this.apellido = apellido;
                this.nombre = nombre;
        }

        @Override
        public String toString() {
                return "Estudiante{" +
                        "id=" + id +
                        ", nombre='" + nombre + '\'' +
                        ", apellido='" + apellido + '\'' +
                        ", numero='" + numero + '\'' +
                        '}';
        }
}

package com.example.mscurso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String nombre;
        private String descripcion;
        private String codigo;

        public Curso() {
        }

        public Curso(Integer id, String nombre, String descripcion, String codigo) {
                this.id = id;
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.codigo = codigo;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getDescripcion() {
                return descripcion;
        }

        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
        }

        public String getCodigo() {
                return codigo;
        }

        public void setCodigo(String codigo) {
                this.codigo = codigo;
        }

        @Override
        public String toString() {
                return "Curso{" +
                        "id=" + id +
                        ", nombre='" + nombre + '\'' +
                        ", descripcion='" + descripcion + '\'' +
                        ", codigo='" + codigo + '\'' +
                        '}';
        }
}

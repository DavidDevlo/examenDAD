package com.example.dnausuario.Servicio;

import com.example.dnausuario.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Usuario usuario);
    Optional<Usuario> listarPorId(Integer id);
    void eliminarPorId(Integer id);
}
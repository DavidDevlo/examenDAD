package com.example.dnausuario.Servicio.Implemento;

import com.example.dnausuario.entity.Usuario;
import com.example.dnausuario.Repositorio.UsuarioRepository;
import com.example.dnausuario.Servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        // Validar correo único
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado: " + usuario.getCorreo());
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        Optional<Usuario> existente = usuarioRepository.findById(usuario.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado con ID: " + usuario.getId());
        }
        // Si cambia el correo, validar que no exista
        if (!existente.get().getCorreo().equals(usuario.getCorreo()) &&
                usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado: " + usuario.getCorreo());
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> listarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

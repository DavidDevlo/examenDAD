package com.example.dnausuario.Controlador;



import com.example.dnausuario.Servicio.UsuarioService;
import com.example.dnausuario.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> list() {
        return ResponseEntity.ok().body(usuarioService.listar());
    }

    @PostMapping()
    public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.guardar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(
            @PathVariable Integer id,
            @Valid @RequestBody Usuario usuario
    ) {
        // Aseguramos que el ID venga en la ruta
        usuario.setId(id);
        return ResponseEntity.ok(usuarioService.actualizar(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listById(@PathVariable Integer id) {
        return usuarioService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        usuarioService.eliminarPorId(id);
        return "Eliminación correcta";
    }
}
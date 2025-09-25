package com.mycompany.seguimiento_habitos.controller;

import com.mycompany.seguimiento_habitos.Repository.UsuarioRepository;
import com.mycompany.seguimiento_habitos.model.Usuario;
import com.mycompany.seguimiento_habitos.Repository.UsuarioRepository;
import com.mycompany.seguimiento_habitos.model.Registro;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository repo) {
        this.usuarioRepository = repo;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
 @GetMapping("/{id}")
public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
    return usuarioRepository.findById(id)
            .map(usuario -> ResponseEntity.ok().body(usuario))
            .orElse(ResponseEntity.notFound().build());
}

    
@PutMapping("/{id}")
public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
    return usuarioRepository.findById(id)
            .map(usuario -> {
                usuario.setNombre(usuarioActualizado.getNombre());
                usuario.setEmail(usuarioActualizado.getEmail());
                usuario.setContrasena(usuarioActualizado.getContrasena()); 
                Usuario actualizado = usuarioRepository.save(usuario);
                return ResponseEntity.ok().body(actualizado);
            })
            .orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
    var usuarioOpt = usuarioRepository.findById(id);
    if (usuarioOpt.isPresent()) {
        usuarioRepository.delete(usuarioOpt.get());
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}
    
}

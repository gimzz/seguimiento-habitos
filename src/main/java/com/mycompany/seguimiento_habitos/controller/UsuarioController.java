package com.mycompany.seguimiento_habitos.controller;

import com.mycompany.seguimiento_habitos.Repository.UsuarioRepository;
import com.mycompany.seguimiento_habitos.model.Usuario;
import com.mycompany.seguimiento_habitos.Repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}

package com.mycompany.seguimiento_habitos.controller;

import com.mycompany.seguimiento_habitos.Repository.HabitoRepository;
import com.mycompany.seguimiento_habitos.Repository.RegistroRepository;
import com.mycompany.seguimiento_habitos.model.Habito;
import com.mycompany.seguimiento_habitos.model.Registro;
import com.mycompany.seguimiento_habitos.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author lmparra
 */
@RestController
@RequestMapping("/registros")
public class RegistroController {

    private final RegistroRepository registroRepository;

    public RegistroController(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    @PostMapping
    public Registro crearRegistro(@RequestBody Registro registro) {
        return registroRepository.save(registro);
    }

    @GetMapping
    public List<Registro> listarRegistros() {
        return registroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro> obtenerRegistroPorId(@PathVariable Long id) {
        return registroRepository.findById(id)
                .map(registro -> ResponseEntity.ok().body(registro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registro> actualizarRegistro(@PathVariable Long id, @RequestBody Registro registroActualizado) {
        return registroRepository.findById(id)
                .map(registro -> {
                    registro.setFecha(registroActualizado.getFecha());
                    registro.setComentario(registroActualizado.getComentario());
                    registro.setHabito(registroActualizado.getHabito());
                    Registro actualizado = registroRepository.save(registro);
                    return ResponseEntity.ok().body(actualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRegistro(@PathVariable Long id) {
        return registroRepository.findById(id)
                .map(registro -> {
                    registroRepository.delete(registro);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

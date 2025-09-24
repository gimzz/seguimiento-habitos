package com.mycompany.seguimiento_habitos.controller;

import com.mycompany.seguimiento_habitos.Repository.HabitoRepository;
import com.mycompany.seguimiento_habitos.model.Habito;
import com.mycompany.seguimiento_habitos.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author lmparra
 */
@RestController
@RequestMapping("/habitos")
public class HabitoController {

    private final HabitoRepository habitoRepository;

    public HabitoController(HabitoRepository habitoRepository) {
        this.habitoRepository = habitoRepository;
    }

    @PostMapping
    public Habito crearHabito(@RequestBody Habito habito) {
        return habitoRepository.save(habito);
    }

    @GetMapping
    public List<Habito> listarHabitos() {
        return habitoRepository.findAll();
    }
}


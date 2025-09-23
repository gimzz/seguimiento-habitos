package com.mycompany.seguimiento_habitos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "¡La API está corriendo correctamente!";
    }
}

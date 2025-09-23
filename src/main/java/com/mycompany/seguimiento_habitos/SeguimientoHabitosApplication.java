package com.mycompany.seguimiento_habitos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SeguimientoHabitosApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeguimientoHabitosApplication.class, args);
    }
}

package com.mycompany.seguimiento_habitos.Repository;

import com.mycompany.seguimiento_habitos.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
}

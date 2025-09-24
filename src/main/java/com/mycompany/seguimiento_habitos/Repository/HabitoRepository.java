package com.mycompany.seguimiento_habitos.Repository;

import com.mycompany.seguimiento_habitos.model.Habito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitoRepository extends JpaRepository<Habito, Long> {
}

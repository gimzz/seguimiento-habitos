package com.mycompany.seguimiento_habitos.Repository;

import com.mycompany.seguimiento_habitos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

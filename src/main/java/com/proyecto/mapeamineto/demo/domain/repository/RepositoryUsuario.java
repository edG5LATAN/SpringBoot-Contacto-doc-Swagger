package com.proyecto.mapeamineto.demo.domain.repository;

import com.proyecto.mapeamineto.demo.domain.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryUsuario extends JpaRepository<Usuario,Long> {
    UserDetails findByLogin(String username);
}

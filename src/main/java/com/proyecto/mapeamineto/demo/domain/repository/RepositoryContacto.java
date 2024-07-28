package com.proyecto.mapeamineto.demo.domain.repository;

import com.proyecto.mapeamineto.demo.domain.model.contacto.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryContacto extends JpaRepository<Contacto,Long> {
    Contacto findByNombre(String nombre);
}

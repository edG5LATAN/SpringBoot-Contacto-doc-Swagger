package com.proyecto.mapeamineto.demo.domain.repository;

import com.proyecto.mapeamineto.demo.domain.model.direccion.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryDireccion extends JpaRepository<Direccion,Long> {

    List<Direccion> findByCiudad(String ciudad);
}

package com.proyecto.mapeamineto.demo.controller;


import com.proyecto.mapeamineto.demo.domain.model.direccion.DatosDireccionNewMostrar;
import com.proyecto.mapeamineto.demo.domain.repository.RepositoryDireccion;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direccion")
@RequiredArgsConstructor
@Tag(name = "Direcction", description = "show all Direction with role all authenticated only ADMIN can search for city")
public class ControllerDireccion{

    private final RepositoryDireccion repositoryDireccion;

    @GetMapping("/mostrar")
    public ResponseEntity<List<DatosDireccionNewMostrar>> mostrar(){
        return ResponseEntity.ok(repositoryDireccion.findAll().stream().map(DatosDireccionNewMostrar::new).toList());
    }

    @GetMapping("/buscar/{ciudad}")
    public ResponseEntity buscarCiudad(@PathVariable String ciudad){
       var direccion=repositoryDireccion.findByCiudad(ciudad);
       if(direccion.isEmpty()){
           return ResponseEntity.noContent().build();
       }
        return ResponseEntity.ok(direccion.stream().map(DatosDireccionNewMostrar::new).toList());
    }


}

package com.proyecto.mapeamineto.demo.controller;


import com.proyecto.mapeamineto.demo.domain.model.usuario.DatosMostrarUsuario;
import com.proyecto.mapeamineto.demo.domain.repository.RepositoryUsuario;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usser", description = "show all Usser only ADMIN role")
public class ControllerUsuario {

    private final RepositoryUsuario repositoryUsuario;


    @GetMapping("/mostrar")
    public List<DatosMostrarUsuario> mostrar(){
        return repositoryUsuario.findAll().stream().map(DatosMostrarUsuario::new).toList();
    }


}

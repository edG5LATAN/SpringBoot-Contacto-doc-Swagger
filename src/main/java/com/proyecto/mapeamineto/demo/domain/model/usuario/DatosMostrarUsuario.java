package com.proyecto.mapeamineto.demo.domain.model.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosMostrarUsuario(
         Long id,
         String login,
         RoleEnum rol
) {
    public DatosMostrarUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getLogin(), usuario.getRol());
    }
}

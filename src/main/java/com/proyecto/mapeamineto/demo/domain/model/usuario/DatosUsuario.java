package com.proyecto.mapeamineto.demo.domain.model.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosUsuario(
       @NotNull String login,
       @NotNull String clave,
       @NotNull RoleEnum rol
) {
}

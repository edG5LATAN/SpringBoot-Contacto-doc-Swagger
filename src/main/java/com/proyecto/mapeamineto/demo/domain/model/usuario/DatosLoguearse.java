package com.proyecto.mapeamineto.demo.domain.model.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosLoguearse(
        @NotNull String login,
        @NotNull String clave
) {
}

package com.proyecto.mapeamineto.demo.domain.model.direccion;

import jakarta.validation.constraints.NotNull;

public record DatosDireccion(
        @NotNull String ciudad,
        @NotNull String colonia
) {
}

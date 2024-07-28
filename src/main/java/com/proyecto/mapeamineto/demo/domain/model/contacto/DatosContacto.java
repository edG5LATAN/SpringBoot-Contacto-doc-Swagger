package com.proyecto.mapeamineto.demo.domain.model.contacto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.proyecto.mapeamineto.demo.domain.model.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;


public record DatosContacto(
        @NotNull String nombre,
        @NotNull String correo,
        @NotNull String telefono,
        @JsonAlias("direccion")
        @NotNull DatosDireccion datosDireccion
) {
}

package com.proyecto.mapeamineto.demo.domain.model.direccion;

import jakarta.validation.constraints.NotNull;

public record DatosDireccionNew(
        @NotNull String correo,
        @NotNull String nombre,
        @NotNull String ciudad,
        @NotNull String colonia
) {
    public DatosDireccionNew(Direccion direccion){
        this(direccion.getContacto().getCorreo(),direccion.getContacto().getNombre(), direccion.getCiudad(), direccion.getColonia());
    }
}

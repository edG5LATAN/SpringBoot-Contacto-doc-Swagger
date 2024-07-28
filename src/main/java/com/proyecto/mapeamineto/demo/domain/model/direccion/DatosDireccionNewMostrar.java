package com.proyecto.mapeamineto.demo.domain.model.direccion;

import jakarta.validation.constraints.NotNull;

public record DatosDireccionNewMostrar(
        String correo,
        String nombre,
        String ciudad,
        String colonia
) {
    public DatosDireccionNewMostrar(Direccion direccion){
        this(direccion.getContacto().getCorreo(),direccion.getContacto().getNombre(), direccion.getCiudad(), direccion.getColonia());
    }
}

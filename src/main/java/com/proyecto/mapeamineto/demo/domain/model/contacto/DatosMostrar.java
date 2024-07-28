package com.proyecto.mapeamineto.demo.domain.model.contacto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.proyecto.mapeamineto.demo.domain.model.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosMostrar(
        Long id,
        String nombre,
        String correo,
        String telefono,
        @JsonAlias("direccion")
        DatosDireccion datosDireccion
) {
    public DatosMostrar(Contacto contacto){
        this(contacto.getId_con(), contacto.getNombre(), contacto.getCorreo(), contacto.getTelefono(),
               new DatosDireccion(contacto.getDireccion().getCiudad(),contacto.getDireccion().getColonia()));
    }
}

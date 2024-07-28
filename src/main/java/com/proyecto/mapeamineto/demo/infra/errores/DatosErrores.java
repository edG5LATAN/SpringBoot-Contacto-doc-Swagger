package com.proyecto.mapeamineto.demo.infra.errores;

import org.springframework.validation.FieldError;

public record DatosErrores(String campo, String error) {
    public DatosErrores(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}

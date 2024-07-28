package com.proyecto.mapeamineto.demo.infra.errores;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class TratadorErrores {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity noEncontrado(){
       return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity noData(MethodArgumentNotValidException e){
        var errores=e.getFieldErrors().stream().map(DatosErrores::new).toList();
        return ResponseEntity.ok(errores);
    }


}

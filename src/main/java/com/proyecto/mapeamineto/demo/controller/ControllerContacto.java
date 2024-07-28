package com.proyecto.mapeamineto.demo.controller;

import com.proyecto.mapeamineto.demo.domain.model.contacto.Contacto;
import com.proyecto.mapeamineto.demo.domain.model.contacto.DatosContacto;
import com.proyecto.mapeamineto.demo.domain.model.contacto.DatosMostrar;
import com.proyecto.mapeamineto.demo.domain.model.direccion.DatosDireccion;
import com.proyecto.mapeamineto.demo.domain.repository.RepositoryContacto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/contacto")
@RequiredArgsConstructor()
@Tag(name = "Contact", description = "show all contact with rol all authenticated only ADMIN can delete contact")
public class ControllerContacto {

    private final RepositoryContacto repositoryContacto;


    @GetMapping("/mostrar")
    public ResponseEntity<Page<DatosMostrar>> mostrar(@PageableDefault(size = 4)Pageable pageable){
        return ResponseEntity.ok(repositoryContacto.findAll(pageable).map(DatosMostrar::new));
    }

    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody @Valid DatosContacto datosContacto, UriComponentsBuilder uriComponentsBuilder){
        var verifyContacto= repositoryContacto.findByNombre(datosContacto.nombre());
        if(verifyContacto==null) {
            var contacto = repositoryContacto.save(new Contacto(datosContacto));
            URI url = uriComponentsBuilder.buildAndExpand("/contacto/unidad/{id}").expand(contacto.getId_con()).toUri();
            return ResponseEntity.created(url).body(new DatosMostrar(contacto.getId_con(), contacto.getNombre(), contacto.getCorreo(), contacto.getTelefono(),
                    new DatosDireccion(contacto.getDireccion().getCiudad(), contacto.getDireccion().getColonia())));
        }else{
            return ResponseEntity.ok("ya existe contacto");
        }
     }


    @GetMapping("/borrar/{id}")
    @Transactional
    public ResponseEntity borrar(@PathVariable Long id){
        var contacto=repositoryContacto.getReferenceById(id);
        repositoryContacto.delete(contacto);
        return ResponseEntity.noContent().build();
    }

}

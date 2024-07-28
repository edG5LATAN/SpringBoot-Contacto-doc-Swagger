package com.proyecto.mapeamineto.demo.controller;

import com.proyecto.mapeamineto.demo.domain.model.usuario.DatosLoguearse;
import com.proyecto.mapeamineto.demo.domain.model.usuario.Usuario;
import com.proyecto.mapeamineto.demo.infra.security.DatosToken;
import com.proyecto.mapeamineto.demo.infra.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loguearse")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Login with user and pass")
public class ControllerLoguearse {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity loguearse(@RequestBody DatosLoguearse datosLoguearse){
        Authentication auToken=new UsernamePasswordAuthenticationToken(datosLoguearse.login(),datosLoguearse.clave());
        var usuario=authenticationManager.authenticate(auToken);
        var token=tokenService.getToken((Usuario) usuario.getPrincipal());
        return ResponseEntity.ok(new DatosToken(token));
    }
//    usuarios ya agregados en la base de datos con encriptacion con BCRYPT
//            ADMIN login=edwin
//                  clave=1234
//            USER login=dania
//                  clave=1234
//            CLIENT login=ana
//                  clave=1234

}

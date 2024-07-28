package com.proyecto.mapeamineto.demo.infra.swagger;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

import java.net.http.HttpHeaders;


@OpenAPIDefinition(
        info = @Info(
             title = "API AGENDA",
             description = "api de agenda con autenticacion y seguridad con usuario",
             termsOfService = "www.edtecnology.com",
             version = "1.0.0",
             contact = @Contact(
                     name = "Edwin Castro",
                     email = "castromaradiaga@hotmail.com",
                     url = "www.EDTecnology.com"
             ),
                license = @License(
                        name = "licencia de edw",
                        url = "www.edtecnology.com"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PRODUCT SERVER",
                        url = "http://devdata:8080"
                )
        },
        security = @SecurityRequirement(
                name = "Security Token"
        )
)
@SecurityScheme(
        name = "Security Token",
        description = "acces token for mi api",
        type = SecuritySchemeType.HTTP,
        paramName = "AUTHORIZATION",
        in = SecuritySchemeIn.HEADER,
        scheme = "Bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
}

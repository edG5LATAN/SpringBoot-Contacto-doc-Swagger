package com.proyecto.mapeamineto.demo.infra.security;

import com.proyecto.mapeamineto.demo.domain.repository.RepositoryUsuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FilterConfiguration extends OncePerRequestFilter {

    private final RepositoryUsuario repositoryUsuario;
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var autToken=request.getHeader("Authorization");
        if(autToken!=null){
            var token=autToken.replace("Bearer ","");
            var subject=tokenService.getSubject(token);
            if(subject!=null){
                var usuario=repositoryUsuario.findByLogin(subject);
                var autenticar= new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(autenticar);
            }
        }
        filterChain.doFilter(request,response);
    }
}

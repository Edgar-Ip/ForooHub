package com.foroohub.ForooHub.controller;

import com.foroohub.ForooHub.domain.loginUser.DatosAutenticacionLoginUser;
import com.foroohub.ForooHub.domain.loginUser.LoginUser;
import com.foroohub.ForooHub.infra.errores.security.DatosJWTToken;
import com.foroohub.ForooHub.infra.errores.security.TokenService;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/login")
    @Table(name= "usuarioslogin")


    public class AutenticacionController {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private TokenService tokenService;

        @PostMapping
        public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionLoginUser datosAutenticacionLoginUser) {
            Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionLoginUser.login(),
                    datosAutenticacionLoginUser.clave());
            var usuarioAutenticado = authenticationManager.authenticate(authToken);
            var JWTtoken = tokenService.generarToken((LoginUser)usuarioAutenticado.getPrincipal());

            return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
        }

    }


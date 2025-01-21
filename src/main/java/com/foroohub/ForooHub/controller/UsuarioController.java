package com.foroohub.ForooHub.controller;

import com.foroohub.ForooHub.domain.usuario.Usuario;
import com.foroohub.ForooHub.domain.usuario.UsuarioRepositorio;
import com.foroohub.ForooHub.domain.usuario.dto.DatosCrearUsuario;
import com.foroohub.ForooHub.domain.usuario.dto.DatosDetallesUsuario;
import com.foroohub.ForooHub.domain.usuario.dto.DatosListaUsuario;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Table(name= "autor")
    @RestController
    @RequestMapping("/usuario")

    public class UsuarioController {

        @Autowired
        private UsuarioRepositorio usuarioRepositorio;


        @PostMapping
        @Transactional
        public ResponseEntity crearUsuario(@RequestBody @Valid DatosCrearUsuario datosCrearUsuario, UriComponentsBuilder uriBuilder){

            var usuario = new Usuario(datosCrearUsuario);
            usuarioRepositorio.save(usuario);

            var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(uri).body(new DatosDetallesUsuario(usuario));

        }

        @GetMapping
        public ResponseEntity<Page<DatosListaUsuario>> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
            var page = usuarioRepositorio.findAll(paginacion).map(DatosListaUsuario::new);
            return ResponseEntity.ok(page);
        }
    }


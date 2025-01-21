package com.foroohub.ForooHub.controller;

import com.foroohub.ForooHub.domain.curso.CursoRepositorio;
import com.foroohub.ForooHub.domain.curso.dto.DatosCrearCurso;
import com.foroohub.ForooHub.domain.curso.dto.DatosDetallesCurso;
import com.foroohub.ForooHub.domain.topico.Topico;
import com.foroohub.ForooHub.domain.topico.TopicoRepositorio;
import com.foroohub.ForooHub.domain.topico.dto.DatosActualizarTopico;
import com.foroohub.ForooHub.domain.topico.dto.DatosCrearTopico;
import com.foroohub.ForooHub.domain.topico.dto.DatosDetalleTopico;
import com.foroohub.ForooHub.domain.topico.dto.DatosListarTopico;
import com.foroohub.ForooHub.domain.usuario.UsuarioRepositorio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")

public class TopicoController {

    @Autowired
    private TopicoRepositorio topicoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private CursoRepositorio cursoRepositorio;


    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleTopico> crear(@RequestBody @Valid DatosCrearTopico datos, UriComponentsBuilder uriBuilder){
        var autor = usuarioRepositorio.findById(datos.idautor())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        var curso = cursoRepositorio.findById(datos.idcurso())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        var topico = new Topico(datos, usuarioRepositorio, cursoRepositorio);
        topicoRepositorio.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));


    }

    @GetMapping
    public Page<DatosListarTopico> ListadoTopico(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacion) {
        return topicoRepositorio.findAll(paginacion).map(DatosListarTopico::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        var topico = topicoRepositorio.getReferenceById(datosActualizarTopico.id());
        topico.actualizarTopico(datosActualizarTopico);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico (@PathVariable Long id) {
        var topico = topicoRepositorio.getReferenceById(id);
        return ResponseEntity.ok(new DatosListarTopico(topico));
    }

    @PutMapping("/verificar-y-actualizar/{id}")
    @Transactional
    public ResponseEntity verificarYActualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        var optionalTopico = topicoRepositorio.findById(id);

        if (optionalTopico.isPresent()) {
            var topicoExistente = optionalTopico.get();
            topicoExistente.actualizarTopico(datos);
            return ResponseEntity.ok(new DatosDetalleTopico(topicoExistente));
        } else {
            // Si no existe, devolver un mensaje adecuado
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar (@PathVariable Long id) {
        var topico = topicoRepositorio.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}



package com.foroohub.ForooHub.domain.curso.dto;

import com.foroohub.ForooHub.domain.curso.Curso;

public record DatosListaCurso(Long id, String nombre, String categoria) {

    public DatosListaCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria().toString());
    }

}

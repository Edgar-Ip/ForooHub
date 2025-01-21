package com.foroohub.ForooHub.domain.curso.dto;

import com.foroohub.ForooHub.domain.curso.Curso;
import jakarta.validation.constraints.NotNull;

public record DatosDetallesCurso(@NotNull Long id, String nombre, String categoria) {

    public DatosDetallesCurso(Curso curso){
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria().toString()
        );
    }

}


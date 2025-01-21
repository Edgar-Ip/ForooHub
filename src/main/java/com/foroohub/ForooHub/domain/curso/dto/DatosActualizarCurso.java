package com.foroohub.ForooHub.domain.curso.dto;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(@NotNull Long id,
                                   String nombreCurso){
}

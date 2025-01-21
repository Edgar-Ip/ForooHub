package com.foroohub.ForooHub.domain.topico.dto;

import com.foroohub.ForooHub.domain.curso.Curso;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        Curso cursoId
) {
}

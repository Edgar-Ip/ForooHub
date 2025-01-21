package com.foroohub.ForooHub.domain.topico.dto;

import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public record DatosCrearTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Long idautor,
        @NotNull
        Long idcurso

){
}

